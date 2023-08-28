#!/bin/bash

../gradlew spring-dynamodb:bootBuildImage
docker build -t spring-dynamodb-function .
docker run --rm --entrypoint cat spring-dynamodb-function function.zip > build/function.zip