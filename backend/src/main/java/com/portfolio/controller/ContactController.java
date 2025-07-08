package com.portfolio.controller;

import com.portfolio.dto.ContactMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @RestController combina @Controller e @ResponseBody, simplificando a criação de APIs RESTful.
 * Todos os métodos nesta classe retornarão JSON por padrão.
 * @RequestMapping("/api/contact") define o prefixo da URL para todos os endpoints neste controller.
 */
@RestController
@RequestMapping("/api/contact")
public class ContactController {

    // Utilizar um Logger é a prática recomendada para logging em vez de System.out.println().
    // SLF4J é uma abstração que permite trocar a implementação de logging (Logback, Log4j2, etc.) sem alterar o código.
    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    /**
     * Endpoint para receber mensagens do formulário de contato.
     * @PostMapping mapeia requisições HTTP POST para /api/contact.
     *
     * @param message O corpo da requisição (@RequestBody) é convertido para um objeto ContactMessage.
     *                A anotação @Valid aciona o mecanismo de validação do Spring, que verifica as
     *                anotações de validação (como @NotBlank, @Email) definidas na classe ContactMessage.
     *                Se a validação falhar, o Spring lança uma exceção MethodArgumentNotValidException,
     *                que resulta em uma resposta HTTP 400 (Bad Request) por padrão.
     * @return Retorna uma resposta HTTP. ResponseEntity.ok() gera uma resposta HTTP 200 (OK),
     *         indicando que a mensagem foi recebida com sucesso.
     */
    @PostMapping
    public ResponseEntity<Void> receiveContactMessage(@Valid @RequestBody ContactMessage message) {
        // O logging estruturado é preferível à concatenação de strings.
        // Ele melhora a legibilidade e facilita a análise de logs com ferramentas automatizadas.
        logger.info("Nova mensagem de contato recebida: Nome='{}', Email='{}'", message.getName(), message.getEmail());

        // Em uma aplicação real, a lógica de negócio (enviar email, salvar no banco)
        // seria delegada a uma camada de serviço (Service Layer).
        // Ex: contactService.processMessage(message);

        // Retornar uma resposta HTTP clara é uma boa prática em APIs REST.
        return ResponseEntity.ok().build();
    }
}