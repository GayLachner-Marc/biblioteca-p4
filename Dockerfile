# ---------- Fase 1: compilación ----------
FROM eclipse-temurin:25-jdk AS build

WORKDIR /app

# Cachea las dependencias antes de copiar el código
COPY mvnw pom.xml ./
COPY .mvn .mvn
RUN chmod +x mvnw && ./mvnw -q dependency:go-offline

# Copia el código y compila
COPY src ./src
RUN ./mvnw -q package -Dmaven.test.skip=true


# ---------- Fase 2: ejecución ----------
FROM eclipse-temurin:25-jre

WORKDIR /app

COPY --from=build /app/target/biblioteca-p4-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]