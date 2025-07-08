package com.portfolio.repository;

import com.portfolio.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório de acesso a dados para a entidade Project.
 * <p>
 * Estende JpaRepository, fornecendo métodos CRUD prontos e integração com o JPA.
 * <p>
 * Boas práticas:
 * - Evite lógica de negócio aqui; mantenha apenas métodos de consulta personalizados, se necessário.
 * - Utilize métodos de query seguros para evitar SQL Injection (o Spring Data JPA já faz isso por padrão).
 * - Se for necessário adicionar queries customizadas, prefira o uso de @Query com parâmetros nomeados.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Caso precise de métodos de busca customizados, declare-os aqui seguindo o padrão do Spring Data JPA.
}
