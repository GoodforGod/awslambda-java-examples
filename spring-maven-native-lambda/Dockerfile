FROM goodforgod/amazonlinux-graalvm:21.0.0.2

ADD target/*dependencies.jar build/libs/lambda.jar

RUN native-image --no-server --no-fallback -classpath build/libs/lambda.jar

ADD bootstrap bootstrap
RUN ls -a
RUN chmod +x bootstrap
RUN chmod +x lambda

RUN zip -j function.zip bootstrap lambda

EXPOSE 8080
ENTRYPOINT ["/home/application/lambda"]
