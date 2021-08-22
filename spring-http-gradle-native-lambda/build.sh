#!/bin/bash

./gradlew bootBuildImage
docker build -t spring-http-gradle-native-lambda-function .
docker run --rm --entrypoint cat spring-http-gradle-native-lambda-function /function.zip > build/function.zip