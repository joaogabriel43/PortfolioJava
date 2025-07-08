-- Remove dados antigos para garantir uma inserção limpa
DELETE FROM certificate;
DELETE FROM project;
DELETE FROM profile;

-- Inserir seu perfil usando os nomes de coluna corretos (snake_case)
INSERT INTO profile (id, name, title, summary, linked_in, git_hub) VALUES
(1, 'João Gabriel Nascimento', 'Software Developer (C#, Angular, SQL)', 'C# and Angular Developer com experiência no ciclo de vida de desenvolvimento de software e manutenção de sistemas usando SQL Server.', 'https://linkedin.com/in/joão-gabriel-borba', 'https://github.com/joaogabriel43');

-- Inserir seus projetos/experiências
INSERT INTO project (title, description, technologies, live_link, source_code_link) VALUES
('Application Engineer | Intermidia', 'Desenvolvimento e manutenção de funcionalidades para sistemas internos usando C#, .NET e Angular. Criação e otimização de queries, stored procedures e functions em SQL Server.', 'C#, .NET, Angular, SQL Server, Git', '', 'https://github.com/joaogabriel43'),
('Help Desk | Compuletra', 'Suporte técnico Nível 1 e 2 para usuários do sistema Vistoria Pro, diagnosticando e resolvendo incidentes, além de realizar atualizações e configurações de software.', 'Suporte Técnico, Vistoria Pro', '', '');

-- Inserir seus certificados
INSERT INTO certificate (title, issuer, date) VALUES
('C# and Object-Oriented Programming Certification', 'Alura', '2022-01-01'),
('Cisco IT Essentials', 'Cisco Networking Academy', '2019-01-01');