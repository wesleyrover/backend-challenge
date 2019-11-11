FROM maven:3.3-jdk-8 as builder

COPY ./back-order /opt

WORKDIR /opt
RUN ls -la
RUN mvn clean install -DskipTests=false

FROM openjdk:8-jre-alpine

WORKDIR /opt

RUN apk --no-cache add --update ttf-dejavu
RUN apk add --no-cache tzdata
ENV TZ America/Bahia

COPY --from=builder /opt/target/back-order-*.jar app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
