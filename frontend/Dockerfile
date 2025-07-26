FROM node:20-alpine

WORKDIR /app

# Instala dependências
COPY package*.json ./
RUN npm ci

# Copia o restante do código
COPY . .

# (Opcional) Build de produção
# RUN npm run build

# Porta padrão do Vite (alterar se precisar)
EXPOSE 5173

# Rodando o servidor do Vite (modo desenvolvimento)
CMD ["npm", "run", "dev", "--", "--host"]
