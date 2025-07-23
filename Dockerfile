# Stage 1: build usando Gradle
FROM gradle:8.7.0-jdk17 AS builder
WORKDIR /app

# Copia apenas arquivos de build para cache de dependências
COPY build.gradle settings.gradle ./
COPY gradle gradle
RUN gradle build --no-daemon || return 0

# Copia o restante do código e gera o jar
COPY . .
RUN gradle clean bootJar --no-daemon

# Stage 2: runtime
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copia o jar gerado do builder
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
