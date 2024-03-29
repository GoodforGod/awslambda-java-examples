## Simple AWSLambda DynamoDB

Java 17+ AWS Lambda Example with Micronaut DI support with GraalVM native compatibility.

## Runtime

Example uses [Simple Lambda](https://github.com/GoodforGod/simple-awslambda) with GraalVM native compatibility.

## Deploy

If you are on Windows and having issues with 
```
Error: fork/exec /var/task/bootstrap: no such file or directory
```

Check bootstrap file that it have **LF line** (Unix one) separator.

## Build

```shell
docker build -t simplelambda-dynamodb .
docker run --rm --entrypoint cat simplelambda-dynamodb /home/application/function.zip > build/function.zip
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

