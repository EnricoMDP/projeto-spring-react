# Use uma imagem base do Maven com JDK 17 para compilar a aplicação
FROM eclipse-temurin:21-jdk AS build

# Atualize os pacotes e instale o Maven
RUN apt-get update && apt-get install -y maven

WORKDIR /app
COPY . .

# Compile o projeto e crie um jar
RUN mvn clean package

# Use uma imagem mais leve com JDK 21 para rodar a aplicação
FROM debian:bullseye-slim

# Atualize os pacotes e instale dependências básicas
RUN apt-get update && apt-get install -y wget curl

# Instale o JDK 21 manualmente no estágio de build
RUN curl -fSL https://download.oracle.com/java/21/latest/jdk-21_linux-x64_bin.tar.gz -o jdk-21_linux-x64_bin.tar.gz \
    && tar -xvzf jdk-21_linux-x64_bin.tar.gz \
    && mkdir -p /opt/jdk-21 \
    && mv jdk-21.0.4/* /opt/jdk-21/ \
    && update-alternatives --install /usr/bin/java java /opt/jdk-21/bin/java 1 \
    && update-alternatives --set java /opt/jdk-21/bin/java

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o jar do estágio de construção anterior
COPY --from=build /app/target/dsmovie-0.0.1-SNAPSHOT.jar /app/dsmovie.jar

# Configure o Java 21 como padrão
ENV PATH="/opt/jdk-21/bin:${PATH}"

# Exponha a porta que a aplicação irá rodar
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "dsmovie.jar"]
