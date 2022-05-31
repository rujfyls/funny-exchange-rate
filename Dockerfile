FROM alpine:latest
RUN apk add openjdk11
COPY /build/libs/exchange-rate.jar /exchange-rate.jar

ENTRYPOINT ["java", "-jar", "/exchange-rate.jar"]