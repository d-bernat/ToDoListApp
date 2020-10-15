FROM maven:3.6-openjdk-11

WORKDIR /app/src

COPY pom.xml .

COPY src src

RUN mvn de.qaware.maven:go-offline-maven-plugin:resolve-dependencies
RUN mvn clean install
ENTRYPOINT ["mvn", "cargo:run"]