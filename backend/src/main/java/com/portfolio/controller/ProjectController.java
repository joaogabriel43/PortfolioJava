package com.portfolio.controller;

import com.portfolio.model.Project;
import com.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller para gerenciar os endpoints relacionados aos projetos do portfólio.
 * A anotação @RestController otimiza a classe para servir requisições REST,
 * retornando JSON por padrão.
 */
@RestController
// Mapeia todas as requisições que começam com /api/projects para este controller.
@RequestMapping("/api/projects")
public class ProjectController {

    // Injeta a dependência do ProjectService. É preferível usar injeção via construtor
    // para garantir a imutabilidade e facilitar os testes unitários.
    @Autowired
    private ProjectService projectService;

    /**
     * Endpoint GET para buscar e retornar a lista de todos os projetos.
     * @return Uma lista de objetos Project. Em uma aplicação mais robusta,
     *         seria ideal retornar um ResponseEntity<List<Project>> para ter
     *         maior controle sobre o status HTTP e os cabeçalhos da resposta.
     */
    @GetMapping
    public List<Project> getProjects() {
        // Delega a chamada para a camada de serviço, que contém a lógica de negócio.
        return projectService.getProjects();
    }
}
