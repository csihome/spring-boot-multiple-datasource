FROM openjdk:8

ARG APP_VERSION=*

# Metadata
LABEL org.label-schema.name="famunity-multiple-data-source" \
      org.label-schema.description="This is sample Spring Boot project with multiple data store"\
      org.label-schema.vendor="FamunityNet"\
      org.label-schema.vcs-url="https://github.com" \
      org.label-schema.docker.dockerfile="/Dockerfile" \
      org.label-schema.docker.params="MYSQL_ENDPOINT=MySQL URI and port" \
      org.label-schema.docker.cmd="docker run -d --name famunity-multiple-data-source \
                                   -p 8080:8080 \
                                   -e MYSQL_ENDPOINT=\"127.0.0.1:3306/test\" \
                                   -e MYSQL_ENDPOINT_OPTION=\"useSSL=false\" \
                                   famunity/famunity-multiple-data-source"

COPY target/multiple-data-source-${APP_VERSION}-exec.jar /multiple-data-source.jar

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/multiple-data-source.jar"]