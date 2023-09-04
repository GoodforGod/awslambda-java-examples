# Quarkus AWSLambda DynamoDB

Example for Quarkus AWS Lambda.

## Build

```shell
./gradlew quarkus-dynamodb:quarkusBuild -Dquarkus.package.type=native -Dquarkus.native.container-build=true
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