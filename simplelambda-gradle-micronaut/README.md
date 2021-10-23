## Simple Lambda

Java 11+ AWS Lambda Template with Micronaut DI support with GraalVM native compatibility.

## Runtime

Template uses [Simple Lambda](https://github.com/GoodforGod/simple-lambda) with GraalVM native compatibility.

## Deploy

If you are on Windows and having issues with 
```
Error: fork/exec /var/task/bootstrap: no such file or directory
```

Check bootstrap file that it have **LF line** (Unix one) separator.

## Build

```shell
./gradlew shadorJar
docker build -t simplelambda-gradle-micronaut .
docker run --rm --entrypoint cat simplelambda-gradle-micronaut /home/application/function.zip > build/function.zip
```

## SAM

```shell
sam local start-api -t sam.yaml -p 3000
```