package com.portfolio.service;

import com.portfolio.model.Project;
import com.portfolio.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Camada de serviço para a entidade Project.
 * A anotação @Service designa esta classe como um componente de serviço,
 * onde a lógica de negócio da aplicação é implementada.
 */
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    /**
     * Injeção de dependência via construtor.
     * Esta é a abordagem recomendada pelo Spring, pois garante que as dependências
     * são obrigatórias (final) e que o objeto é imutável após a criação.
     * Facilita também os testes unitários, permitindo a injeção de mocks.
     *
     * @param projectRepository O repositório para acesso aos dados dos projetos.
     */
    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    /**
     * Busca e retorna todos os projetos do banco de dados.
     *
     * @return Uma lista de objetos Project.
     *         Para aplicações com um grande número de projetos, a implementação de
     *         paginação (usando Pageable) seria crucial para otimizar a performance
     *         e o uso de memória.
     */
    public List<Project> getProjects() {
        // A chamada é delegada ao método findAll() do JpaRepository,
        // que abstrai a consulta SQL para buscar todos os registros da tabela de projetos.
        return projectRepository.findAll();
    }

    // Métodos para criar, atualizar e deletar projetos (CRUD) poderiam ser adicionados aqui.
    // Ex: public Project saveProject(Project project) { ... }
    //     public void deleteProject(Long id) { ... }
}
