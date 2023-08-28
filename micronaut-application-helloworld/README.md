# Micronaut AWSLambda HelloWorld

Simple Micronaut Hello World application lambda.

## Build

Building Micronaut AWSLambda native executable is quite easy and require 3 steps only:

1) Build JAR:
```shell
./gradlew micronaut-application-helloworld:shadowJar
```

2) Build native executable via Docker:
```shell
docker build -t micronaut-application-helloworld .
```

3) Extract native executable from container:
```shell
docker run --rm --entrypoint cat micronaut-application-helloworld /home/application/function.zip > build/function.zip
```

## SAM

```shell
sam local start-api -t sam.yaml -p 3000
```

## Event Example

Example of event to send to lambda:
```json
{
  "body": "{\"name\":\"Steeven King\"}",
  "httpMethod": "POST",
  "isBase64Encoded": false,
  "path": "/"
}
```

## More
- https://docs.micronaut.io/latest/guide/#serverlessFunctions
- https://micronaut-projects.github.io/micronaut-aws/latest/guide/#lambda
- https://guides.micronaut.io/latest/mn-serverless-function-aws-lambda-gradle-java.html