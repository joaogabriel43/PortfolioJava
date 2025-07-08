package com.portfolio.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Data Transfer Object (DTO) para encapsular os dados do formulário de contato.
 * Utilizar um DTO é uma boa prática para desacoplar a camada de controle (Controller)
 * da camada de modelo (Model/Entity), recebendo apenas os dados necessários e aplicando validações específicas.
 */
public class ContactMessage {

    /**
     * Nome do remetente.
     * A anotação @NotBlank garante que o campo não seja nulo nem contenha apenas espaços em branco.
     * A anotação @Size define o tamanho máximo, prevenindo entradas excessivamente longas (e possíveis ataques).
     */
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome não pode ter mais de 100 caracteres")
    private String name;

    /**
     * Email do remetente.
     * A anotação @Email valida se o formato do campo corresponde a um endereço de e-mail válido.
     * @NotBlank e @Size cumprem as mesmas funções do campo 'name'.
     */
    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O email deve ser válido")
    @Size(max = 100, message = "O email não pode ter mais de 100 caracteres")
    private String email;

    /**
     * Conteúdo da mensagem.
     * Validações semelhantes são aplicadas para garantir que a mensagem não seja vazia
     * e que não exceda o limite de caracteres definido.
     */
    @NotBlank(message = "A mensagem é obrigatória")
    @Size(max = 500, message = "A mensagem não pode ter mais de 500 caracteres")
    private String message;

    // Getters e Setters são necessários para que o framework (Spring/Jackson)
    // possa realizar a desserialização (JSON para Objeto) e serialização (Objeto para JSON) dos dados.
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
