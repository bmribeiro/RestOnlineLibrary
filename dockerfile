# Imagem JDK
FROM openjdk:17-jdk-slim

# Define o argumento JAR_FILE
ARG JAR_FILE=target/*.jar

# Copia o arquivo JAR para o contêiner com o nome app.jar
COPY ${JAR_FILE} restOnlineLibrary-0.0.1.jar

# Expõe a porta
EXPOSE 8080

# Define o comando de entrada para iniciar a aplicação
ENTRYPOINT ["java","-jar","/restOnlineLibrary-0.0.1.jar"]