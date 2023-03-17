FROM eclipse-temurin
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src .
CMD ["./mvnw", "spring-boot:run"]