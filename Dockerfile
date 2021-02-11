FROM registry.access.redhat.com/openjdk/openjdk-11-rhel7

# Create app directory
WORKDIR /opt/app

#RUN mvn clean install package

# Refer to Maven build -> finalName
ARG JAR_FILE=target/policy-api-gold-0.0.1-SNAPSHOT.jar

# cp target/policy-api-gold-0.0.1-SNAPSHOT.jar /opt/app/app.jar
COPY ${JAR_FILE} policy-api-gold.jar

#EXPOSE 8080
CMD ["java","-jar","policy-api-gold.jar"]