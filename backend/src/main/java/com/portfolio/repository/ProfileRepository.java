package com.portfolio.repository;
import com.portfolio.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório para a entidade Profile, gerenciado pelo Spring Data JPA.
 *
 * Ao estender JpaRepository, esta interface herda automaticamente métodos para
 * operações CRUD (Create, Read, Update, Delete) e outras funcionalidades de
 * persistência, como paginação e ordenação. O Spring Data JPA gera a
 * implementação em tempo de execução.
 *
 * @param Profile A entidade que este repositório gerencia.
 * @param Long O tipo da chave primária da entidade (o ID do perfil).
 */
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    // Métodos de consulta personalizados podem ser declarados aqui.
    // O Spring Data JPA os implementará automaticamente com base no nome do método.
    // Ex: findByName(String name);
}
