package com.portfolio.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

/**
 * Entidade JPA que representa um projeto no portfólio.
 * A anotação @Entity a designa como uma tabela no banco de dados.
 */
@Entity
public class Project {
    /**
     * Chave primária da tabela, com geração automática de valor pelo banco de dados.
     * @Id define o campo como chave primária.
     * @GeneratedValue(strategy = GenerationType.IDENTITY) utiliza a estratégia de
     * auto-incremento do próprio banco de dados para gerar o ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Título do projeto. Não pode ser nulo ou vazio.
     */
    @NotBlank(message = "O título é obrigatório")
    @Size(max = 150, message = "O título não pode exceder 150 caracteres")
    private String title;

    /**
     * Descrição detalhada do projeto.
     */
    @NotBlank(message = "A descrição é obrigatória")
    @Size(max = 1000, message = "A descrição não pode exceder 1000 caracteres")
    private String description;

    /**
     * Tecnologias utilizadas no projeto.
     */
    @NotBlank(message = "As tecnologias são obrigatórias")
    @Size(max = 255, message = "O campo de tecnologias não pode exceder 255 caracteres")
    private String technologies;

    /**
     * Link para a versão ao vivo do projeto. Deve ser uma URL válida.
     * A anotação @URL valida o formato do link.
     */
    @URL(message = "O link ao vivo deve ser uma URL válida")
    private String liveLink;

    /**
     * Link para o código-fonte do projeto. Deve ser uma URL válida.
     */
    @URL(message = "O link do código-fonte deve ser uma URL válida")
    private String sourceCodeLink;

    // Getters e Setters são essenciais para o funcionamento do JPA e do Jackson (serialização/desserialização)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public String getLiveLink() {
        return liveLink;
    }

    public void setLiveLink(String liveLink) {
        this.liveLink = liveLink;
    }

    public String getSourceCodeLink() {
        return sourceCodeLink;
    }

    public void setSourceCodeLink(String sourceCodeLink) {
        this.sourceCodeLink = sourceCodeLink;
    }
}
