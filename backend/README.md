<p align="center">
  <a href="#" target="_blank">
  <img src="https://raw.githubusercontent.com/joaogabriel43/PortfolioJava/main/.github/assets/logo.jpg" alt="Project Logo" width="150">
  </a>
</p>

<h1 align="center">Portfólio Pessoal - João Gabriel N.</h1>

<p align="center">
  Um portfólio web moderno e dinâmico, desenvolvido para demonstrar habilidades em desenvolvimento Full-Stack com uma arquitetura desacoplada. A aplicação apresenta uma API RESTful robusta construída com Java e Spring Boot, e um front-end leve e responsivo utilizando tecnologias web padrão.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-blue.svg" alt="Java 17">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg" alt="Spring Boot 3.x">
  <a href="https://github.com/joaogabriel43/PortfolioJava/actions/workflows/ci.yml">
  </a>
  <a href="LICENSE">
    <img src="https://img.shields.io/badge/license-MIT-blue.svg" alt="Licença">
  </a>
</p>

<details>
<summary><strong>📚 Tabela de Conteúdos</strong></summary>
  <ol>
    <li><a href="#-sobre-o-projeto">Sobre o Projeto</a></li>
    <li><a href="#-arquitetura-e-funcionalidades-chave">Arquitetura</a></li>
    <li><a href="#-tecnologias-utilizadas">Tecnologias</a></li>
    <li><a href="#-começando">Começando</a></li>
    <li><a href="#-licença">Licença</a></li>
    <li><a href="#-contato">Contato</a></li>
  </ol>
</details>

---

## 📜 Sobre o Projeto

Este projeto foi criado como uma vitrine profissional para exibir informações de perfil, projetos realizados e certificados obtidos.
A arquitetura foi pensada para ser escalável e manutenível, separando claramente as responsabilidades entre o back-end (que gerencia os dados e a lógica de negócio) e o front-end (que cuida da apresentação ao usuário).

### ✨ Funcionalidades Chave

* **API RESTful Completa:** Endpoints para gerenciar dinamicamente o conteúdo do portfólio.
* **Seção de Perfil:** Exibe informações profissionais e de contato.
* **Galeria de Projetos:** Apresenta os projetos desenvolvidos com descrições e links.
* **Exibição de Certificados:** Lista as certificações e qualificações.
* **Formulário de Contato:** Permite que visitantes enviem mensagens diretamente.

---

## 🏛️ Arquitetura e Decisões

[cite_start]A estrutura do projeto segue uma filosofia de design que prioriza a clareza, manutenibilidade e as melhores práticas da indústria. [cite: 4, 809]

- **Arquitetura em Camadas (Separation of Concerns):** Aderimos a uma estrita separação de responsabilidades. `Controllers` lidam apenas com a camada HTTP, `Services` orquestram a lógica de negócio e `Repositories` gerenciam o acesso a dados. [cite_start]Essa separação impede o acoplamento e torna o sistema mais fácil de entender e modificar. [cite: 1754, 1826]
- **Padrão DTO (Data Transfer Object):** Utilizamos DTOs para criar um contrato claro para a API, desacoplando a camada web das entidades de domínio e fornecendo uma camada extra de segurança contra vulnerabilidades de "Mass Assignment".
- **Tratamento de Exceções Centralizado:** Um `@ControllerAdvice` global captura exceções customizadas (`ResourceNotFoundException`, `BusinessRuleException`), garantindo que a API retorne respostas de erro HTTP padronizadas e consistentes.
- [cite_start]**Qualidade Garantida por Testes:** Acreditamos que testes são uma parte integral do desenvolvimento. [cite: 814] A suíte de testes de unidade com **JUnit 5 e Mockito** valida cada peça da lógica de negócio de forma isolada, permitindo refatorações seguras e desenvolvimento ágil.

---

## 🛠️ Tecnologias Utilizadas

| Back-end | Front-end | Banco de Dados & Ferramentas |
| :--- | :--- | :--- |
| ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) | ![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white) | ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white) |
| ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white) | ![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white) | ![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white) |
| ![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white) | ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black) | ![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white) |

---

## 🚀 Começando

Para executar este projeto localmente, siga os passos abaixo.

### ✅ Pré-requisitos

Garanta que você tenha as seguintes ferramentas instaladas:

* **Java Development Kit (JDK):** Versão 17 ou superior
* **Apache Maven:** Para build e dependências do back-end
* **PostgreSQL:** Ou o banco relacional de sua preferência
* **Git:** Para clonar o repositório

### ⚙️ Configuração e Execução

#### 1. Back-end (API)

```bash
# 1. Clone o repositório
git clone [https://github.com/joaogabriel43/PortfolioJava.git](https://github.com/joaogabriel43/PortfolioJava.git)
cd PortfolioJava/backend

# 2. Configure o Banco de Dados
#    Abra o arquivo `src/main/resources/application.properties` e ajuste:
#    spring.datasource.url=jdbc:postgresql://localhost:5432/portfolio_db
#    spring.datasource.username=[SEU_USUARIO_DO_BANCO]
#    spring.datasource.password=[SUA_SENHA_DO_BANCO]

# 3. Instale as dependências e execute a aplicação
mvn spring-boot:run
```

O servidor da API será iniciado na porta **8080**.

---

#### 2. Front-end (Interface do Usuário)

```bash
# Em um novo terminal, navegue até a pasta do front-end
cd PortfolioJava/frontend

# Inicie um servidor web local. Se você tiver Python 3 instalado, pode usar:
python -m http.server 8000
```
Após iniciar o servidor, acesse [http://localhost:8000](http://localhost:8000) no seu navegador para ver o portfólio em ação.

---

## 📄 Licença

Este projeto é distribuído sob a Licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

---

## 📬 Contato

**João Gabriel Borba do Nascimento**

- LinkedIn: [linkedin.com/in/joão-gabriel-borba](https://www.linkedin.com/in/joão-gabriel-borba/)
- Email: joaogabrielnb43@gmail.com
- GitHub: [github.com/joaogabriel43](https://github.com/joaogabriel43)