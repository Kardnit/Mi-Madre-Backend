FROM openjdk:17
EXPOSE 25060
ADD target/mimadre.jar mimadre.jar
ENTRYPOINT ["java", "-jar", "/mimadre.jar"]