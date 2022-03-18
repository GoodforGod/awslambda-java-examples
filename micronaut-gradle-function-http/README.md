# Micronaut Lambda

Template for Micronaut 2 service for Java 11+.

## Features
- Micronaut Plugin for BOM and version management.
- Spotless for Code Style check and apply.
- .gitignore and .gitattributes for proper ignore and symbols check.
- .editorconfig for simple configs code style and encoding UTF-8.
- Proper Gradle and Gradle Wrapper configuration.

## Build

```shell
docker build -t micronaut-gradle-function-http .
docker run --rm --entrypoint cat micronaut-gradle-function-http /home/application/function.zip > build/function.zip
```

## SAM

```shell
sam local start-api -t sam.yaml -p 3000
```

## More
- https://docs.micronaut.io/latest/guide/#serverlessFunctions
- https://micronaut-projects.github.io/micronaut-aws/latest/guide/#lambda
- https://guides.micronaut.io/latest/mn-serverless-function-aws-lambda-gradle-java.html