package com.portfolio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Classe de configuração global para o Spring MVC.
 * A anotação @Configuration indica que esta classe contém definições de beans
 * e configurações para o contexto da aplicação Spring.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Injeta o valor da propriedade 'cors.allowed-origins' do arquivo application.properties.
     * Usar @Value desacopla a configuração do código, permitindo que as origens permitidas
     * sejam alteradas sem a necessidade de recompilar a aplicação.
     */
    @Value("${cors.allowed-origins}")
    private String allowedOrigins;

    /**
     * Configura o Cross-Origin Resource Sharing (CORS) para a aplicação.
     * CORS é um mecanismo de segurança do navegador que restringe requisições HTTP
     * de um domínio diferente do domínio do recurso solicitado.
     * Esta configuração é essencial para permitir que o frontend (ex: em http://localhost:8000)
     * se comunique com o backend.
     *
     * @param registry O registro de configurações CORS.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Aplica a configuração CORS para todos os endpoints sob /api/
                .allowedOrigins(allowedOrigins) // Permite requisições da origem definida em application.properties
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
                .allowedHeaders("*") // Permite todos os cabeçalhos na requisição
                .allowCredentials(true); // Permite o envio de cookies e credenciais de autenticação
    }
}
