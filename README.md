# 🧳 Agência de Viagens - API REST
Projeto de uma API REST para uma agência de viagens fictícia.

---

## 🔍 Visão Geral do Problema

Uma agência de viagens que está modernizando seus serviços digitais já possui um site institucional e um sistema interno de reservas, mas deseja ampliar sua atuação por meio de uma API REST que permita a integração com aplicativos de turismo, parceiros comerciais e futuras plataformas digitais.

Assim, ela solicitou uma primeira versão funcional de uma API.

A agência trabalha com informações sobre destinos turísticos, pacotes de viagem, disponibilidade de hotéis, localização, descrição dos destinos, avaliações e atividades turísticas. Neste primeiro momento, o sistema não precisa estar integrado a um banco de dados real nem possuir mecanismos avançados de segurança. O foco será a definição da arquitetura da solução, a organização do projeto e a construção dos endpoints principais da API.

---

## Arquitetura Proposta
Este projeto é uma API que segue os princípios REST para lidar com as solicitações GET, POST, PUT e DELETE. Além disso, é estruturado em quatro camadas distintas:
- **Controller:** Responsável por receber as solicitações do cliente e respondê-las, utilizando os métodos contidos na camada Service;
- **Service:** É onde se realiza a lógica de negócio, através da manipulação da entidade;
- **Entity:** Representa a entidade de Destination;
- **Repository:** Futuramente conterá o relacionamento com Banco de Dados.

---

## 📌 Principais Decisões Tomadas
### Justificativa da Linguagem:
Java foi escolhida por ser uma linguagem de programação de forte tipagem muito bem estabelecida no mercado de trabalho.
### Frameworks Escolhidos:
- Spring: O framework mais popular do ecossistema Java. Possui Inversão de Controle e Injeção de Dependência.
- Spring Web: Voltado à construção de sistemas WEB.

Estes frameworks foram utilizados juntamente com o Maven, um gerenciador de dependências do ecossistema Java.

---

## 🛠️ Estrutura Geral da Aplicação

### Principais Endpoints:

### Endpoints **GET**:
- **getAllDestinations:** Retorna ao usuário a lista completa com todos os `DestinationEntity` e suas informações. Disponível em `/api/destinationEntities`.
- **getDestinationById:** Retorna ao usuário o `DestinationEntity` e suas informações, cujo `id` seja igual ao que está na URL. Disponível em `/api/destinationEntities/id`.
- **searchDestinations:** Retorna ao usuário os `Destinations` e suas informações, cujo `Nome` ou `Locate` correspondam ao que está na URL. Disponível em `/api/destinationEntities/search`.

### Endpoint **POST**:
- **createDestination:** Cria um `DestinationEntity` e o armazena em memória. Disponível em `/api/destinationEntities`.

### Endpoints **PUT**:
- **updateDestination:**: Edita as informações de um `DestinationEntity`. Disponível em `/api/destinationEntities/id`.
- **addReview**: Adiciona uma avaliação à `DestinationEntity` e altera sua média de avaliação. Disponível em `/api/destinationEntities/id/reviews`.

### Endpoint **DELETE**:
- **deleteDestination:** Exclui uma `DestinationEntity`. Disponível em `/api/destinationEntities/id`.

- - -

## ⚙️ Como Executar o Projeto

### Pré-requisitos
* **JAVA** instalado na máquina (versão 25 ou superior)**.

### Passo a Passo

1. **Clone este repositório:**
```bash
  git clone https://github.com/GustavoTamaninis/agencia-viagens.git
```
2. **Entre na pasta:**
```bash
  cd agencia-viagens
```
3. **Execute:**
- No Windows:

  ```bash
  mvnw.cmd spring-boot:run
  ```
- No Linux/macOS:

  ```bash
  ./mvnw spring-boot:run
  ```
4. A API ficará disponível em:
    http://localhost:8080



