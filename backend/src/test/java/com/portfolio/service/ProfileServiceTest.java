package com.portfolio.service;

import com.portfolio.model.Profile;
import com.portfolio.repository.ProfileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe de teste para o ProfileService.
 * A anotação @ExtendWith(MockitoExtension.class) inicializa os mocks do Mockito
 * e os injeta nos campos anotados com @Mock e @InjectMocks.
 */
@ExtendWith(MockitoExtension.class)
public class ProfileServiceTest {

    /**
     * Cria um mock (objeto simulado) do ProfileRepository.
     * Isso nos permite simular o comportamento do repositório sem precisar de um
     * banco de dados real, isolando o teste para a lógica do serviço.
     */
    @Mock
    private ProfileRepository profileRepository;

    /**
     * Injeta os mocks criados (neste caso, profileRepository) na instância de ProfileService.
     * O Mockito criará uma instância de ProfileService e injetará o mock do repositório nela.
     */
    @InjectMocks
    private ProfileService profileService;

    /**
     * Testa o método getProfile para garantir que ele retorna o perfil corretamente.
     * O nome do método segue o padrão test[NomeDoMetodo]().
     */
    @Test
    public void testGetProfile() {
        // Arrange: Configuração do cenário de teste.
        Profile profile = new Profile(); // Cria um objeto de perfil para o teste.
        profile.setId(1L);
        profile.setName("Your Name");

        // Define o comportamento esperado do mock: quando o método findById(1L) for chamado,
        // ele deve retornar um Optional contendo o nosso objeto de perfil.
        Mockito.when(profileRepository.findById(1L)).thenReturn(Optional.of(profile));

        // Act: Execução do método que está sendo testado.
        Optional<Profile> result = profileService.getProfile();

        // Assert: Verificação dos resultados.
        // Verifica se o Optional retornado contém um valor.
        assertTrue(result.isPresent(), "O perfil deveria ser encontrado");
        // Verifica se o nome do perfil retornado é o esperado.
        assertEquals("Your Name", result.get().getName(), "O nome do perfil não corresponde ao esperado");
    }
}
