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

# Baixa o OpenTelemetry Agent (aqui é melhor, pois não precisa dele no build)
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar .

# Stage 2: runtime
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copia o jar gerado do builder
COPY --from=builder /app/build/libs/*.jar app.jar
# Copia o agente baixado no builder stage
COPY --from=builder /app/opentelemetry-javaagent.jar ./opentelemetry-javaagent.jar

EXPOSE 8080

# Para facilitar configs externas, use JAVA_TOOL_OPTIONS ou argumentos em runtime
ENV JAVA_TOOL_OPTIONS "-javaagent:/app/opentelemetry-javaagent.jar"

ENTRYPOINT ["sh", "-c", "java $JAVA_TOOL_OPTIONS -jar /app/app.jar"]
