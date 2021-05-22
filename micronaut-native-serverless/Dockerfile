FROM goodforgod/amazonlinux-graalvm:21.0.0.2

ADD build/libs/*all.jar build/libs/lambda.jar

RUN native-image --no-server -cp build/libs/lambda.jar

ADD bootstrap bootstrap
RUN chmod +x bootstrap
RUN chmod +x lambda

RUN zip -j function.zip bootstrap lambda

EXPOSE 8080
ENTRYPOINT ["/home/application/lambda"]
