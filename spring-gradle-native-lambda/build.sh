#!/bin/bash

./gradlew bootBuildImage
docker build -t spring-gradle-native-lambda-function .
docker run --rm --entrypoint cat spring-gradle-native-lambda-function /function.zip > build/function.zip