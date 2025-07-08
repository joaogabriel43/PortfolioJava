package com.portfolio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Ponto de entrada principal da aplicação Spring Boot.
 *
 * A anotação @SpringBootApplication é uma conveniência que combina três outras anotações:
 * 1. @Configuration: Marca a classe como uma fonte de definições de beans para o contexto da aplicação.
 * 2. @EnableAutoConfiguration: Instrui o Spring Boot a começar a adicionar beans com base nas
 *    configurações do classpath, outros beans e várias configurações de propriedade.
 * 3. @ComponentScan: Diz ao Spring para procurar por outros componentes, configurações e serviços
 *    no pacote 'com.portfolio', permitindo que ele encontre e registre os controllers, services, etc.
 */
@SpringBootApplication
public class PortfolioApplication {

    /**
     * O método main que serve como ponto de partida para a execução da aplicação.
     *
     * @param args Argumentos de linha de comando que podem ser passados para a aplicação.
     */
    public static void main(String[] args) {
        // SpringApplication.run() inicializa a aplicação, criando o contexto da aplicação
        // e iniciando o servidor web embutido (Tomcat, por padrão).
        SpringApplication.run(PortfolioApplication.class, args);
    }
}
