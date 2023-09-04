# Micronaut AWSLambda DynamoDB

Micronaut function lambda for DynamoDB.

## Build

Building Micronaut AWSLambda native executable is quite easy and require 3 steps only:

1) Build JAR:
```shell
./gradlew micronaut-function-dynamodb:shadowJar
```

2) Build native executable via Docker:
```shell
docker build -t micronaut-function-dynamodb .
```

3) Extract native executable from container:
```shell
docker run --rm --entrypoint cat micronaut-function-dynamodb /home/application/function.zip > build/function.zip
```

## SAM

You can run AWS emulator (SAM) locally to emulate and test deployment like it is AWS Lambda Cloud.

```shell
sam local start-api -t sam.yaml -p 3000
```

## Event Example

Example of event to send to lambda:
```json
{
  "name": "Steeven King"
}
```

## More
- https://docs.micronaut.io/latest/guide/#serverlessFunctions
- https://micronaut-projects.github.io/micronaut-aws/latest/guide/#lambda
- https://guides.micronaut.io/latest/mn-serverless-function-aws-lambda-gradle-java.html