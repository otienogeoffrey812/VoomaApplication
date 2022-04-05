FROM adoptopenjdk/openjdk11:ubi
ADD target/VoomaApplication-0.0.1-SNAPSHOT.jar VoomaApplication-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "VoomaApplication-0.0.1-SNAPSHOT.jar"]