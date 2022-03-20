# Quarkus Lambda

Template for Quarkus.

## Features
- Micronaut Plugin for BOM and version management.
- Spotless for Code Style check and apply.
- .gitignore and .gitattributes for proper ignore and symbols check.
- .editorconfig for simple configs code style and encoding UTF-8.
- Proper Gradle and Gradle Wrapper configuration.

## Build

```shell
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true -Dquarkus.native.builder-image=quay.io/quarkus/ubi-quarkus-native-image:22.0.0-java17
```

## SAM

```shell
sam local start-api -t sam.yaml -p 3000
```

## More
- https://quarkus.io/guides/amazon-lambda