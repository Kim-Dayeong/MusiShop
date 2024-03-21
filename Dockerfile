FROM amazoncorretto:11
EXPOSE 8083
#ARG JAR_FILE=build/libs/*.jar
ARG JAR_FILE=build/libs/Musishop-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} musi-springboot.jar
#COPY ${JAR_FILE} app.jar
COPY ${JAR_FILE} .
ENTRYPOINT ["java","-jar","/musi-springboot.jar"]
CMD ["-Dspring.profiles.active=local"]