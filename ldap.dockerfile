FROM openjdk:8-jdk-alpine
MAINTAINER PlanoCarreira
COPY target/ldapService.jar /var
WORKDIR /var
CMD ["java","-jar","ldapService.jar"]
