# Spring AWSLambda DynamoDB

Spring 3 AWS Lambda for simple DynamoDB.

## Features
- spring Plugin for BOM and version management.
- Spotless for Code Style check and apply.
- .gitignore and .gitattributes for proper ignore and symbols check.
- .editorconfig for simple configs code style and encoding UTF-8.
- Proper Gradle and Gradle Wrapper configuration.

## Build

All Services, Components, Beans must be annotation @Component, @Service, etc. even if they are constructed manually without DI. (who knows why, that's Spring magic)

```shell
./gradlew bootBuildImage
docker build -t spring-dynamodb-function .
docker run --rm --entrypoint cat spring-dynamodb-function /function.zip > build/function.zip
```

## SAM

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
- https://spring.io/blog/2021/03/11/announcing-spring-native-beta
- https://spring.io/blog/2021/06/14/spring-native-0-10-0-available-now
- https://www.baeldung.com/spring-native-intro
- https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/
- https://spring.io/guides/gs/spring-boot-docker/
- https://spring.io/blog/2020/01/27/creating-docker-images-with-spring-boot-2-3-0-m1
- https://paketo.io/docs/howto/java/
- https://github.com/spring-projects-experimental/spring-native/tree/main/samples/cloud-function-aws
- https://docs.spring.io/spring-cloud-function/docs/current/reference/html/aws-intro.html
- https://docs.spring.io/spring-boot/docs/current/reference/html/native-image.html
