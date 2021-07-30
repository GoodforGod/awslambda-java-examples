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
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```