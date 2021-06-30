#!/bin/bash

docker build -t spring-maven-native-lambda .
mkdir -p build
docker run --rm --entrypoint cat spring-maven-native-lambda /home/application/function.zip > target/function.zip

sam local start-api -t sam.yaml -p 3000
