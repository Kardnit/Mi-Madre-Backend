FROM openjdk:17
EXPOSE 8080
ADD target/mimadre.jar mimadre.jar
ENTRYPOINT ["java", "-jar", "/mimadre.jar"]