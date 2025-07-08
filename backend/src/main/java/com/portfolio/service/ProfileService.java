package com.portfolio.service;
import com.portfolio.model.Profile;
import com.portfolio.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * Camada de serviço para a entidade Profile.
 * @Service marca esta classe para ser gerenciada pelo Spring como um bean de serviço,
 * onde a lógica de negócio principal deve residir.
 */
@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    /**
     * Injeção de dependência via construtor.
     * Esta é a abordagem recomendada pelo Spring, pois garante que as dependências
     * são obrigatórias (final) e que o objeto é imutável após a criação.
     * Facilita também os testes unitários, permitindo a injeção de mocks.
     *
     * @param profileRepository O repositório para acesso aos dados do perfil.
     */
    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    /**
     * Busca o perfil principal do portfólio.
     * A lógica assume que existe um único perfil com ID fixo (1L).
     *
     * @return Um Optional<Profile> contendo o perfil se encontrado, ou um Optional.empty()
     *         se não houver nenhum perfil com o ID 1 no banco de dados.
     *         A camada de controller será responsável por tratar o caso de o perfil não ser encontrado.
     */
    public Optional<Profile> getProfile() {
        // Busca o perfil pelo ID fixo 1. Esta é uma convenção comum para
        // aplicações de portfólio que exibem um único perfil.
        return profileRepository.findById(1L);
    }
}
