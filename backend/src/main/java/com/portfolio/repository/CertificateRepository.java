package com.portfolio.repository;
import com.portfolio.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório para a entidade Certificate.
 * Spring Data JPA criará uma implementação em tempo de execução para esta interface.
 *
 * Ao estender JpaRepository, esta interface herda um conjunto completo de métodos
 * para operações de persistência (CRUD - Create, Read, Update, Delete),
 * eliminando a necessidade de escrever implementações de boilerplate.
 *
 * @param Certificate A entidade que este repositório gerencia.
 * @param Long O tipo da chave primária da entidade (neste caso, o ID do certificado).
 */
public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
