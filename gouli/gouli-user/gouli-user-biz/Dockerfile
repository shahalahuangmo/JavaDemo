FROM java:8
VOLUME /tmp
ADD gouli-user-biz.jar app.jar
EXPOSE 8081
ENTRYPOINT [ "java", "-jar", "/app.jar" ]