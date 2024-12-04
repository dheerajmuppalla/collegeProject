FROM openjdk:22-jdk

COPY /target/college.jar /app/college.jar
WORKDIR /app

CMD ["java", "-jar", "college.jar"]