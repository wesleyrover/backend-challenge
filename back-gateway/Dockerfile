FROM maven:3.3-jdk-8 as builder

COPY . /opt

WORKDIR /opt/back-gateway
RUN mvn clean install

FROM openjdk:8-jre-alpine

WORKDIR /opt

RUN apk --no-cache add --update ttf-dejavu
RUN apk add --no-cache tzdata
ENV TZ America/Bahia

COPY --from=builder /target/back-gateway-0.0.1-SNAPSHOT app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
