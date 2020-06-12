FROM data.pin90.top:5000/jdk11:release
ARG JAR_FILE
ADD ${JAR_FILE} /app.jar
ENTRYPOINT ["java", "-jar","-server","-Xms128m","-Xmx500m","-Dcom.sun.management.jmxremote.rmi.port=10016","-Dcom.sun.management.jmxremote.port=10017","-Dcom.sun.management.jmxremote.ssl=false","-Dcom.sun.management.jmxremote.authenticate=false","-Djava.rmi.server.hostname=data.pin90.top","/app.jar"]