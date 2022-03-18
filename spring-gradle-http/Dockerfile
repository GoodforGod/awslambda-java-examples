FROM spring-gradle-http:0.9.0-SNAPSHOT

USER root

RUN apt update
RUN apt install zip --yes

ADD bootstrap bootstrap

RUN chmod +x bootstrap
RUN chmod +x /workspace/LambdaEntrypoint

RUN zip -j function.zip bootstrap /workspace/LambdaEntrypoint