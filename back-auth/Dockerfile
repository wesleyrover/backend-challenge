FROM maven:3.3-jdk-8 as builder

COPY ./back-auth /opt

WORKDIR /opt
RUN mvn install

FROM openjdk:8-jre-alpine

WORKDIR /opt
RUN ls -la

RUN apk --no-cache add --update ttf-dejavu
RUN apk add --no-cache tzdata
ENV TZ America/Bahia

COPY --from=builder /opt/target/back-auth-*.jar app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/opt/app.jar"]
