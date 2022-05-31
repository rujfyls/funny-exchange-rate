FROM alpine:latest
RUN apk add openjdk11
COPY /build/libs/exchange-rate.jar /exchange-rate.jar

ENTRYPOINT ["java", "-jar", "/exchange-rate.jar"]

#docker pull rujfyls/exchange-rate:latest
#docker run -ti --rm -p 8080:8080 rujfyls/exchange-rate:latest