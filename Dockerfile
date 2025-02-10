# Usando imagem base do Maven para construir o projeto
FROM maven:3.8.4-openjdk-17-slim AS build

# Diretório de trabalho
WORKDIR /app

# Copiar o código-fonte e o arquivo POM
COPY pom.xml .
COPY src ./src

# Rodar o Maven para construir o projeto
RUN mvn clean package -DskipTests

# Agora rodar a imagem WildFly
FROM jboss/wildfly:latest

# Copiar o WAR gerado para o WildFly
COPY --from=build /app/target/backend-3.4.2.war /opt/jboss/wildfly/standalone/deployments/

# Expor a porta
EXPOSE 8080

# Iniciar o WildFly
CMD ["standalone.sh", "-b", "0.0.0.0"]
