# Spring Lambda

Template for spring 2 service for Java 11+.

## Features
- spring Plugin for BOM and version management.
- Spotless for Code Style check and apply.
- .gitignore and .gitattributes for proper ignore and symbols check.
- .editorconfig for simple configs code style and encoding UTF-8.
- Proper Gradle and Gradle Wrapper configuration.

## Build

```shell
./gradlew bootBuildImage
docker build -t spring-gradle-native-lambda-function .
docker run --rm --entrypoint cat spring-gradle-native-lambda-function /function.zip > build/function.zip
```