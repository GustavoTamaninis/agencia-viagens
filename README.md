# ✈️ Agência de Viagens - API REST

Projeto de uma API REST para uma agência de viagens.

---

## 🔍 Sobre o Projeto

O **Agência de Viagens API REST** é um projeto desenvolvido em **Java** utilizando **Spring Boot**.

A ideia do projeto é criar uma API para uma agência de viagens, permitindo o cadastro e gerenciamento de destinos turísticos e usuários.

Através da API é possível cadastrar, consultar, alterar e excluir destinos, pesquisar destinos pelo nome ou localização e registrar avaliações.

---

## 🛠️ Tecnologias Utilizadas

- ☕ Java
- 🍃 Spring Boot
- 🌐 Spring Web
- 💾 Spring Data JPA
- 🔐 Spring Security
- 🐘 PostgreSQL
- 🗃️ Flyway
- 📦 Maven

---

## 🏗️ Organização do Projeto

O projeto foi separado em camadas para manter o código organizado.

- **Controller:** responsável pelas rotas e requisições da API.
- **Service:** onde ficam as regras e operações do sistema.
- **Repository:** responsável pelo acesso ao banco de dados.
- **Entity:** representa as entidades utilizadas no banco.
- **DTO:** utilizado para receber e retornar os dados da aplicação.

As principais entidades utilizadas são:

- `Destination`
- `User`
- `Review`

---

## 🔐 Regras de Acesso

A API utiliza **Spring Security** para controlar o acesso às rotas.

Algumas rotas podem ser acessadas livremente, enquanto outras precisam de autenticação ou permissão de administrador.

### 🔑 Autenticação

Para acessar as rotas protegidas, primeiro é necessário realizar o login.

A autenticação é feita através da rota:

`POST /auth/login`

Nessa requisição são enviados os dados de login do usuário.

Depois de autenticado, o usuário poderá acessar as rotas permitidas de acordo com seu nível de acesso.

Para realizar operações que exigem autenticação, como adicionar uma avaliação em um destino, o usuário precisa estar logado.

### 🚦 Acesso às Rotas

| Método | Rota | Acesso |
|---|---|---|
| POST | `/auth/login` | Público |
| GET | `/api/destinations` | Público |
| GET | `/api/destinations/{id}` | Público |
| GET | `/api/destinations/search?search={termo}` | Público |
| PUT | `/api/destinations/{id}/reviews` | Usuário autenticado |
| POST | `/api/destinations` | ADMIN |
| PUT | `/api/destinations/{id}` | ADMIN |
| DELETE | `/api/destinations/{id}` | ADMIN |

As rotas de consulta podem ser acessadas sem login.

Para adicionar uma avaliação, o usuário precisa estar autenticado.

As operações de cadastro, alteração e exclusão de destinos são restritas ao administrador.

As configurações de autenticação e autorização ficam no `SecurityConfig.java`.

---

## 🌎 Destinos

A rota principal utilizada para os destinos é:

`/api/destinations`

### 📋 Listar Todos os Destinos

`GET /api/destinations`

Retorna todos os destinos cadastrados no sistema.

### 🔎 Buscar Destino por ID

`GET /api/destinations/{id}`

Exemplo:

`GET /api/destinations/1`

Busca um destino específico pelo seu ID.

### 🔍 Buscar Destino por Nome ou Localização

`GET /api/destinations/search?search={termo}`

Exemplo:

`GET /api/destinations/search?search=Paris`

A busca pode ser feita utilizando o nome ou a localização do destino.

### ➕ Cadastrar Destino

`POST /api/destinations`

Cadastra um novo destino no sistema.

Essa operação é permitida somente para usuários com acesso de **ADMIN**.

### ✏️ Atualizar Destino

`PUT /api/destinations/{id}`

Atualiza os dados de um destino já cadastrado.

Essa operação é permitida somente para usuários com acesso de **ADMIN**.

### ⭐ Adicionar Avaliação

`PUT /api/destinations/{id}/reviews`

Adiciona uma avaliação ao destino informado.

Para utilizar essa rota, o usuário precisa estar autenticado. Qualquer usuário autenticado pode adicionar uma avaliação, não sendo necessário possuir acesso de administrador.

### 🗑️ Excluir Destino

`DELETE /api/destinations/{id}`

Exclui um destino pelo ID informado.

Essa operação é permitida somente para usuários com acesso de **ADMIN**.

---

## 👤 Usuários

A rota principal utilizada para usuários é:

`/users`

### 📋 Listar Usuários

`GET /users`

Retorna os usuários cadastrados.

### 🔎 Buscar Usuário por ID

`GET /users/{id}`

Busca um usuário específico pelo seu ID.

### ➕ Cadastrar Usuário

`POST /users`

Cadastra um novo usuário.

### ✏️ Atualizar Usuário

`PUT /users/{id}`

Atualiza os dados de um usuário já cadastrado.

### 🗑️ Excluir Usuário

`DELETE /users/{id}`

Exclui um usuário pelo ID informado.

---

## 🗄️ Banco de Dados

O projeto utiliza **PostgreSQL** como banco de dados.

Para executar a aplicação, é necessário criar e configurar o banco de dados com as mesmas informações definidas no arquivo:

`src/main/resources/application.properties`

No projeto, os dados de conexão utilizados são:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/agencia-viagens
spring.datasource.username=postgres
spring.datasource.password=postgres
```

Ao criar a conexão em um gerenciador de PostgreSQL, como **pgAdmin** ou **DBeaver**, devem ser utilizados os mesmos dados:

- **Host:** `localhost`
- **Porta:** `5432`
- **Banco de dados:** `agencia-viagens`
- **Usuário:** `postgres`
- **Senha:** `postgres`

> ⚠️ **Importante:** o banco e a conexão devem ser criados com as mesmas informações definidas no `application.properties` para que a aplicação consiga se conectar corretamente.

---

## 🗃️ Flyway

O projeto utiliza **Flyway** para controlar a criação e as alterações das tabelas do banco de dados.

Os arquivos de migration ficam em:

`src/main/resources/db/migration`

---

## ▶️ Como Executar o Projeto

Para executar o projeto é necessário ter instalado:

- ☕ Java
- 🐘 PostgreSQL

Com o PostgreSQL instalado, crie e configure a conexão utilizando as mesmas informações presentes no `application.properties`.

Para a configuração atual do projeto, devem ser utilizados:

- **Host:** `localhost`
- **Porta:** `5432`
- **Banco:** `agencia-viagens`
- **Usuário:** `postgres`
- **Senha:** `postgres`

Depois de criar o banco e configurar a conexão com essas informações, o projeto pode ser iniciado.

### 🪟 Executar no Windows

```bash
mvnw.cmd spring-boot:run
```

### 🐧 Executar no Linux ou macOS

```bash
./mvnw spring-boot:run
```

Depois que o projeto iniciar, a API ficará disponível em:

`http://localhost:8080`

---

## ⚙️ Funcionalidades

O projeto possui as seguintes funcionalidades:

1. Cadastro de destinos;
2. Consulta dos destinos cadastrados;
3. Busca de destino por ID;
4. Busca de destinos por nome ou localização;
5. Alteração de destinos;
6. Exclusão de destinos;
7. Avaliação de destinos;
8. Cadastro de usuários;
9. Consulta de usuários;
10. Alteração de usuários;
11. Exclusão de usuários;
12. Autenticação de usuários;
13. Controle de acesso às rotas.

---

## 🛡️ Resumo das Permissões

O sistema possui três situações de acesso:

### 🌐 Público

Pode consultar e pesquisar destinos e acessar a rota de login.

### 👤 Usuário Autenticado

Além das rotas públicas, pode adicionar avaliações aos destinos.

### 👑 ADMIN

Possui acesso às operações administrativas, como cadastrar, alterar e excluir destinos.

---

## 📝 Considerações Finais

O projeto **Agência de Viagens API REST** foi desenvolvido para colocar em prática os conteúdos estudados sobre desenvolvimento de APIs utilizando Java e Spring Boot.

Durante o desenvolvimento foram utilizados conceitos de:

- API REST;
- CRUD;
- Arquitetura em camadas;
- Banco de dados;
- Spring Data JPA;
- DTOs;
- Flyway;
- Autenticação;
- Controle de acesso com Spring Security.



