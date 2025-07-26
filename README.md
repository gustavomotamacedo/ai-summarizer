# AI Summarizer

Página WEB e Restful API para resumir textos utilizando IA Generativa.

## 📦 Estrutura do Projeto

```
/
├── backend/        # Backend da aplicação (Java Spring Boot)
├── frontend/       # Frontend da aplicação (TypeScript/React e Vite)
├── docker-compose.yml
```

## 🚀 Como rodar localmente

> É necessário ter [Docker](https://www.docker.com/get-started) instalado.

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/seu-usuario/ai-summarizer.git
   cd ai-summarizer
   ```

2. **Suba os serviços com Docker Compose:**

   ```bash
   docker-compose up
   ```

   Para rodar em background (opcional):

   ```bash
   docker-compose up -d
   ```

3. **Acesse a aplicação:**

   * **Frontend:** [http://localhost:8080](http://localhost:8080)
   * **Backend/API:** [http://localhost:8081](http://localhost:8081)

## 🛠 Principais Comandos

* **Parar os containers:**

  ```bash
  docker-compose down
  ```

* **Ver logs dos serviços:**

  ```bash
  docker-compose logs -f
  ```

## 🤖 Sobre o Projeto

O AI Summarizer é uma aplicação composta por um backend em Java e um frontend em React. Ela permite resumir textos usando IA Generativa por meio de uma API Restful, podendo escolher entre resumos por bullet points ou em formato de tweet.

## 📄 Licença

Este projeto está licenciado sob a licença MIT.