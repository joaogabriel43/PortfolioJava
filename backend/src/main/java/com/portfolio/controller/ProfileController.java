package com.portfolio.controller;

import com.portfolio.model.Profile;
import com.portfolio.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller para gerenciar o endpoint de perfil do usuário.
 * @RestController simplifica a criação de APIs REST, retornando JSON por padrão.
 */
@RestController
// Define o prefixo da URL para todos os endpoints neste controller.
@RequestMapping("/api/profile")
public class ProfileController {

    private final ProfileService profileService;

    /**
     * Injeção de dependência via construtor. Garante que o controller
     * receba suas dependências no momento da instanciação.
     * @param profileService O serviço para a lógica de negócio do perfil.
     */
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    /**
     * Endpoint GET para buscar o perfil do usuário.
     * @return Um ResponseEntity com o perfil encontrado e status 200 (OK),
     *         ou um status 404 (Not Found) se o perfil não existir.
     *         Usar ResponseEntity oferece um controle explícito sobre a resposta HTTP.
     */
    @GetMapping
    public ResponseEntity<Profile> getProfile() {
        // Delega a busca para o serviço e mapeia o resultado do Optional
        // para uma resposta HTTP apropriada.
        return profileService.getProfile()
                .map(ResponseEntity::ok) // Se presente, retorna 200 OK com o perfil no corpo
                .orElse(ResponseEntity.notFound().build()); // Se ausente, retorna 404 Not Found
    }
}
