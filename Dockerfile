FROM gradle:7.4-jdk17-alpine AS build
WORKDIR /home/app
COPY . /home/app
RUN gradle clean build -x test

FROM eclipse-temurin:17-jdk-alpine
ENV ARTIFACT_NAME=openapiv3-sample-1.0.0.jar
VOLUME /tmp
EXPOSE 8088
COPY --from=build /home/app/build/libs/$ARTIFACT_NAME app.jar
ENTRYPOINT [ "sh", "-c" ]
CMD [ "exec java \
      -jar app.jar]
