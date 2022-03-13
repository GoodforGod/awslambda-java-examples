#!/bin/bash

./gradlew bootBuildImage
docker build -t spring-gradle-dynamodb-function .
docker run --rm --entrypoint cat spring-gradle-dynamodb-function /function.zip > build/function.zip