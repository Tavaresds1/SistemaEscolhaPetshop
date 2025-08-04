# Melhor Petshop

Este projeto tem como objetivo encontrar o melhor petshop para banhos em cães pequenos e grandes, com base na data e quantidade informada. O sistema considera variações de preços e se o dia é final de semana para calcular a melhor opção.

---

## 🧩 Tecnologias Utilizadas

### Backend:
- Java 17
- Spring Boot
- Spring Web
- Validação com Bean Validation (javax)
- Arquitetura em camadas (Controller, Service, Domain, DTO)
- Manipulação de exceções centralizada

### Frontend:
- React
- CSS puro com responsividade
- `lucide-react` para ícones

---

## 🚀 Instruções para Executar o Sistema

### 🔧 Backend (Spring Boot)
1. **Pré-requisitos:** Java 17+, Maven
2. No terminal, vá até a pasta do backend:
   ```bash
   mvn spring-boot:run
   ```
3. O backend estará disponível em: `http://localhost:8080`

### 💻 Frontend (React)
1. **Pré-requisitos:** Node.js 16+
2. Vá até a pasta do frontend e execute:
   ```bash
   npm install
   npm start
   ```
3. A aplicação abrirá automaticamente em `http://localhost:3000`

---

## 📌 Premissas Assumidas

- A data é informada no formato `dd/MM/yyyy`.
- O valor do banho varia nos finais de semana.
- O sistema considera apenas petshops previamente cadastrados (sem persistência).

---

## ⚙️ Decisões de Projeto

- **Separação clara de responsabilidades:** uso de DTOs para entrada/saída, services para regras de negócio e controller para orquestração.
- **Validação personalizada:** erros de validação retornam em formato de mapa com mensagens legíveis ao frontend.
- **Design responsivo e acessível:** estilo limpo com `App.css`, adaptado para dispositivos móveis.
- **Mensagens amigáveis e claras:** tanto em caso de sucesso como de erro.

---

## 📄 Estrutura de Pastas

```bash
📁 backend
 ├── controller
 ├── dto
 ├── model
 ├── service
 ├── exception (GlobalExceptionHandler)

📁 frontend
 ├── App.js
 ├── App.css
 └── ...
```

---

## 🧪 Testes

Ainda não foram incluídos testes automatizados, mas a lógica de seleção pode ser facilmente testada com JUnit no service.

---

## ❗ Possíveis Melhorias Futuras

- Integração com banco de dados para CRUD de petshops
- Autenticação de usuários (login/admin)
- Adição de testes unitários e integração
- Deploy em ambiente cloud (ex: Vercel + Render)

---

## ✨ Como funciona

1. O usuário informa:
   - A data
   - Quantidade de cães pequenos
   - Quantidade de cães grandes
2. O frontend valida os campos e envia os dados via POST para o backend.
3. O backend avalia o melhor petshop com base em preço total.
4. O resultado é exibido com nome do petshop e o valor.

---

## 📫 Contato

Caso tenha dúvidas ou sugestões, entre em contato comigo pelo GitHub ou e-mail!

