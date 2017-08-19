FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD weatherapi-boot-0.0.1.jar weatherapi.jar
RUN sh -c 'touch /weatherapi.jar'
ENV JAVA_OPTS="-Dspring.profiles.active=prod"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /weatherapi.jar" ]