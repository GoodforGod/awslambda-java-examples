FROM spring-gradle-dynamodb:0.9.0-SNAPSHOT

USER root

RUN apt update
RUN apt install zip --yes

ADD bootstrap bootstrap

RUN chmod +x bootstrap
RUN chmod +x /workspace/io.aws.lambda.spring.LambdaEntrypoint

RUN zip -j function.zip bootstrap /workspace/io.aws.lambda.spring.LambdaEntrypoint