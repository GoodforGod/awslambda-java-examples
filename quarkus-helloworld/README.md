# Quarkus AWSLambda HelloWorld

Example for Quarkus AWS Lambda.


## Build

```shell
./gradlew quarkus-helloworld:quarkusBuild -Dquarkus.package.type=native -Dquarkus.native.container-build=true -Dquarkus.native.builder-image=quay.io/quarkus/ubi-quarkus-graalvmce-builder-image:22.3-java17
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
- https://quarkus.io/guides/gradle-tooling
- https://quarkus.io/guides/amazon-lambda
- https://quarkus.io/guides/writing-native-applications-tips