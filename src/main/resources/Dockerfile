FROM docker-registry-default.apps.appcanvas.net/test/test-java11:latest

LABEL MANTAINER="Exemple"

# Environment variable
ENV SPRING_LOGGING_LEVEL INFO
ENV SPRING_PROFILE deploy
ENV PORT 8080
ENV JVM_XMS 512m
ENV JVM_XMX 1024m

# Add file to image on build
ADD target/*.jar /app/app.jar
ADD app.sh /

RUN chmod 0755 /app.sh

CMD /app.sh

EXPOSE ${PORT}