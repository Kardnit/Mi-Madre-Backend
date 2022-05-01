# define base docker image
FROM openjdk:17-alpine
LABEL maintainer="Borga"
ADD target/MiMadre-0.0.1-SNAPSHOT.jar mimadre-docker.jar
ENTRYPOINT ["java", "-jar", "mimadre-docker.jar"]