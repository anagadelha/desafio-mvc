# Desafio MVC

## Sobre o Projeto
O projeto desenvolvido é uma aplicação web para gerenciar eventos. A ferramenta permite criar, editar, visualizar e excluir seus respectivos elementos. Requer uma autenticação para acesso.

Elementos disponíveis para uso, sendo eles livremente configuráveis pelo administrador:
- Eventos: Nome, data inicial e data final.
- Grupos: Nome, quantidade de pessoas, evento correspondente e pontuação.
- Participantes: Nome, nível, e-mail, quatro letras da GFT e grupo correspondente.
- Atividades: Nome, data inicial, data de entrega e evento correspondente.

## Como utilizar
Como as páginas de criação e edição possuem acesso bloqueado ao público, o administrador deve primeiramente se cadastrar através da plataforma para poder realizar seu login. A partir daí, a navegação pelos menus e as ferramentas são liberadas para uso.

PS: No arquivo application.properties, coloque seu usuário e senha do banco de dados para que a aplicação possa se conectar.

## Tecnologias Utilizadas
**IDE: Spring Tool Suite**

**Versão do Java: Java 17**

- Spring Boot 2.7.4
- Spring Security
- Spring Data JPA
- Thymeleaf
- Maven
- JUnit 4
- Mockito
- MySQL 8 + MySQL Workbench
- HTML 5 + Bootstrap 5

### Desenvolvedoras
- Alice Alves
- [Ana Gadelha](https://github.com/anagadelha)
- [Caroline Dainezi](https://github.com/carol-dainezi)
- [Jéssika Silveira](https://github.com/jesilveira)