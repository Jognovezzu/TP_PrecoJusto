
FROM openjdk

WORKDIR /app

COPY precojusto-0.0.1-SNAPSHOT.jar app.jar
COPY precojusto1.jrxml /app/PrecoJusto1.jrxml

ENTRYPOINT ["java", "-jar", "app.jar"]