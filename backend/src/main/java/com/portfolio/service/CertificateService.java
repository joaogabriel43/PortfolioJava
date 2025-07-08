package com.portfolio.service;
import com.portfolio.model.Certificate;
import com.portfolio.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Camada de serviço para a entidade Certificate.
 * A anotação @Service indica que esta classe contém a lógica de negócio da aplicação.
 * O Spring gerencia a instância desta classe como um bean.
 */
@Service
public class CertificateService {

    // Injeção de dependência do repositório de certificados.
    // É preferível usar injeção via construtor para garantir que a dependência
    // seja final e não nula, além de facilitar os testes unitários.
    @Autowired
    private CertificateRepository certificateRepository;

    /**
     * Busca e retorna todos os certificados do banco de dados.
     *
     * @return Uma lista de objetos Certificate.
     *         Em cenários com grande volume de dados, seria importante implementar
     *         paginação para evitar problemas de performance e consumo de memória.
     */
    public List<Certificate> getCertificates() {
        // Delega a chamada ao método findAll() do JpaRepository,
        // que executa uma consulta para retornar todos os registros da tabela de certificados.
        return certificateRepository.findAll();
    }

    // Aqui poderiam ser implementados outros métodos de negócio, como:
    // - findById(Long id) com tratamento para certificado não encontrado.
    // - save(Certificate certificate) com validações de negócio.
    // - delete(Long id).
}
