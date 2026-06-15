# ============================================================
# STAGE 1 — BUILD
# Usa uma imagem Maven+JDK para compilar o projeto
# ============================================================
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

# Copia o pom.xml primeiro para aproveitar o cache de layers do Docker.
# Se o pom.xml não mudar, o Docker não baixa as dependências novamente.
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Agora copia o código-fonte e faz o build
COPY src ./src
RUN mvn clean package -DskipTests -B

# ============================================================
# STAGE 2 — RUNTIME
# Usa apenas o JRE (menor), sem Maven, sem código-fonte
# ============================================================
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copia apenas o JAR gerado no stage anterior
COPY --from=builder /app/target/*.jar app.jar

# Porta que o Spring Boot expõe (deve bater com server.port)
EXPOSE 8080

# Variável de ambiente para ativar o profile correto no Render.
# No Render você vai querer um profile de produção, não "local".
ENV SPRING_PROFILES_ACTIVE=prod

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]