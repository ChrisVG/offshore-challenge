FROM openjdk:8-jre
MAINTAINER christian.valencia@globant.com
ADD build/libs/interview-0.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=dev","-jar","/app.jar"]