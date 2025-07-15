package com.portfolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * Configuração central de segurança da aplicação.
 * Integra o Spring Security com a política de CORS.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Define a cadeia de filtros de segurança que será aplicada a todas as requisições.
     * Esta é a configuração de segurança moderna e baseada em componentes do Spring Security.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desabilita o CSRF, pois estamos construindo uma API REST stateless
                // e não usando sessões baseadas em cookies para autenticação de formulário.
                .csrf(csrf -> csrf.disable())

                // Configura o CORS para usar as definições do bean 'corsConfigurationSource'.
                // Esta é a integração crucial entre CORS e Spring Security.
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                // Gerenciamento de sessão: define a política como STATELESS,
                // o que significa que o servidor não criará ou usará sessões HTTP.
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // Define as regras de autorização para as requisições HTTP.
                .authorizeHttpRequests(authorize -> authorize
                        // Permite que todas as requisições para endpoints sob /api/** sejam acessadas publicamente.
                        // ATENÇÃO: Em uma aplicação real, aqui teríamos regras mais granulares
                        // (ex: .requestMatchers("/api/admin/**").hasRole("ADMIN")).
                        .antMatchers("/api/**").permitAll()

                        // Exige autenticação para qualquer outra requisição.
                        .anyRequest().authenticated()
                );

        return http.build();
    }

    /**
     * Define a fonte de configuração do CORS.
     * Este bean é usado pelo filtro de segurança do Spring para aplicar a política de CORS.
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Define as origens permitidas. Use a porta do seu servidor de front-end.
        // O ideal é que isso venha de um arquivo de propriedades em produção.
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:63342"));

        // Define os métodos HTTP permitidos.
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Define os cabeçalhos permitidos.
        configuration.setAllowedHeaders(Arrays.asList("*"));

        // Permite o envio de credenciais (como cookies).
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Aplica esta configuração a todos os caminhos da aplicação.
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}