# Micronaut AWSLambda



## Build

```shell
docker build -t micronaut-gradle-application-helloworld .
docker run --rm --entrypoint cat micronaut-gradle-application-helloworld /home/application/function.zip > build/function.zip
```

## SAM

```shell
sam local start-api -t sam.yaml -p 3000
```

## More
- https://docs.micronaut.io/latest/guide/#serverlessFunctions
- https://micronaut-projects.github.io/micronaut-aws/latest/guide/#lambda
- https://guides.micronaut.io/latest/mn-serverless-function-aws-lambda-gradle-java.html