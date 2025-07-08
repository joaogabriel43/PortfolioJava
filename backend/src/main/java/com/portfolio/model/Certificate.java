package com.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

/**
 * Entidade JPA que representa um certificado no banco de dados.
 * A anotação @Entity marca esta classe como uma entidade gerenciada pelo JPA.
 */
@Entity
public class Certificate {

    /**
     * Chave primária da tabela.
     * @Id marca este campo como a chave primária.
     * @GeneratedValue(strategy = GenerationType.IDENTITY) configura a geração do valor
     * para ser delegada ao banco de dados (usando colunas de auto-incremento).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Título do certificado.
     * A validação @NotBlank garante que o campo não seja nulo ou vazio.
     */
    @NotBlank(message = "O título não pode estar em branco")
    private String title;

    /**
     * Instituição emissora do certificado.
     */
    @NotBlank(message = "O emissor não pode estar em branco")
    private String issuer;

    /**
     * Data de emissão do certificado.
     * @NotNull garante que a data não seja nula.
     * @PastOrPresent garante que a data não seja no futuro.
     */
    @NotNull(message = "A data não pode ser nula")
    @PastOrPresent(message = "A data de emissão deve ser no passado ou presente")
    private LocalDate date;

    // Getters e Setters são necessários para que o JPA e frameworks como o Jackson
    // possam acessar e modificar os campos da entidade.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
