FROM maven:3.6.3-jdk-11

ENV PROJECT_DIR=/opt/project

RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR

ADD ./pom.xml $PROJECT_DIR

RUN mvn dependency:resolve

ADD ./src/ $PROJECT_DIR/src
ADD ./package.json $PROJECT_DIR/
ADD ./webpack.config.js $PROJECT_DIR/

RUN mvn install

FROM openjdk:11-jdk

ENV PROJECT_DIR=/opt/project
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR
COPY --from=0 $PROJECT_DIR/target/japan-sentense* $PROJECT_DIR/

EXPOSE 8080

CMD ["java", "-jar", "/opt/project/japan-sentense-0.2.1-SNAPSHOT.jar"]

