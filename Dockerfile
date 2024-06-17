FROM eclipse-temurin:17-jre-jammy
ARG TARGET_DIR
RUN mkdir /opt/app
WORKDIR /opt/app
COPY  /${TARGET_DIR}/target/*.jar app.jar
CMD ["java","-jar","app.jar"]