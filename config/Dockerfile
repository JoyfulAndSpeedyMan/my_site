FROM data.pin90.top:5000/jdk11:release
ARG JAR_FILE
ADD ${JAR_FILE} /app.jar
ENTRYPOINT ["java", "-jar","-Duser.timezone=GMT+08","-server","-Xms128m","-Xmx500m","/app.jar"]