## Simple Lambda

Java 11+ AWS Lambda Template with Micronaut DI support with GraalVM native compatibility.

## Runtime

Template uses [AWS Lambda Runtime](https://github.com/GoodforGod/aws-lambda-runtime-micronaut) with GraalVM native compatibility.

## Deploy

If you are on Windows and having issues with 
```
Error: fork/exec /var/task/bootstrap: no such file or directory
```

Check bootstrap file that it have **LF line** (Unix one) separator.

## Build

```shell
./gradlew shadorJar
docker build -t simple-gradle-native-lambda .
docker run --rm --entrypoint cat simple-gradle-native-lambda /home/application/function.zip > build/function.zip
```