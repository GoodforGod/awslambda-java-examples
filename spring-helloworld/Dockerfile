FROM spring-helloworld:1.0.0

USER root

RUN apt update
RUN apt install zip --yes

ADD bootstrap bootstrap

RUN chmod +x bootstrap
RUN chmod +x io.goodforgod.spring.LambdaEntrypoint

RUN zip -j function.zip bootstrap io.goodforgod.spring.LambdaEntrypoint