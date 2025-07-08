package com.portfolio.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

/**
 * Entidade JPA que representa o perfil do usuário no portfólio.
 * A anotação @Entity indica que esta classe será mapeada para uma tabela no banco de dados.
 */
@Entity
public class Profile {
    /**
     * Chave primária da entidade.
     * Neste caso, o ID não é autogerado (@GeneratedValue), o que sugere que
     * ele será atribuído manualmente ou que haverá apenas um perfil fixo (ex: ID 1).
     */
    @Id
    private Long id;

    /**
     * Nome do proprietário do portfólio.
     */
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome não pode exceder 100 caracteres")
    private String name;

    /**
     * Título ou cargo profissional.
     */
    @NotBlank(message = "O título é obrigatório")
    @Size(max = 150, message = "O título não pode exceder 150 caracteres")
    private String title;

    /**
     * Resumo profissional ou biografia.
     */
    @NotBlank(message = "O resumo é obrigatório")
    @Size(max = 2000, message = "O resumo não pode exceder 2000 caracteres")
    private String summary;

    /**
     * Link para o perfil do LinkedIn. Deve ser uma URL válida.
     */
    @URL(message = "O link do LinkedIn deve ser uma URL válida")
    @NotBlank(message = "O link do LinkedIn é obrigatório")
    private String linkedIn;

    /**
     * Link para o perfil do GitHub. Deve ser uma URL válida.
     */
    @URL(message = "O link do GitHub deve ser uma URL válida")
    @NotBlank(message = "O link do GitHub é obrigatório")
    private String gitHub;

    // Getters e Setters são necessários para o JPA e para a serialização/desserialização de dados.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getGitHub() {
        return gitHub;
    }

    public void setGitHub(String gitHub) {
        this.gitHub = gitHub;
    }
}
