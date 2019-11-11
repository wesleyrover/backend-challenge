FROM maven:3.3-jdk-8 as builder

COPY ./back-gateway /opt

WORKDIR /opt
RUN mvn install

FROM openjdk:8-jre-alpine

WORKDIR /opt

RUN apk --no-cache add --update ttf-dejavu
RUN apk add --no-cache tzdata
ENV TZ America/Bahia

COPY --from=builder /opt/target/back-gateway-0.0.1-SNAPSHOT.jar back-gateway-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "back-gateway-0.0.1-SNAPSHOT.jar"]
