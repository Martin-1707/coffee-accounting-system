FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

COPY . .

# Otorgar permisos de ejecución al wrapper de Maven
RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

# -------

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
