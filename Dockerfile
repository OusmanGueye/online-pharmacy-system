FROM openjdk:17
LABEL maintainer='sarayatech.com'
ADD target/EPharmacy-0.0.1-SNAPSHOT.jar Epharmacy.jar
ENTRYPOINT ["java", "-jar", "Epharmacy.jar"]