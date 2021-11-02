FROM goodforgod/amazonlinux-graalvm:21.3.0-java17-amd64

ADD build/libs/*all.jar build/libs/lambda.jar

RUN native-image --no-fallback -classpath build/libs/lambda.jar

ADD bootstrap bootstrap
RUN chmod +x bootstrap
RUN chmod +x application

RUN zip -j function.zip bootstrap application

EXPOSE 8080
ENTRYPOINT ["/home/application/application"]
