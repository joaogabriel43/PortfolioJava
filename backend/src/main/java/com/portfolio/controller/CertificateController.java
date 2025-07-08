package com.portfolio.controller;

import com.portfolio.model.Certificate;
import com.portfolio.service.CertificateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller responsável por expor os endpoints de certificados do portfólio.
 */
@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    private final CertificateService certificateService;

    /**
     * Injeção de dependência via construtor, a abordagem recomendada pelo Spring.
     * Garante que o controller tenha suas dependências necessárias no momento da criação.
     *
     * @param certificateService O serviço que contém a lógica de negócio para certificados.
     */
    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    /**
     * Endpoint GET para listar todos os certificados cadastrados.
     *
     * @return ResponseEntity contendo a lista de certificados e o status HTTP 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Certificate>> getCertificates() {
        // Busca todos os certificados através do serviço e os retorna no corpo da resposta.
        List<Certificate> certificates = certificateService.getCertificates();
        return ResponseEntity.ok(certificates);
    }
}
