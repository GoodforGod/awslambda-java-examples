#!/bin/bash

docker build -t spring-native-serverless .
mkdir -p build
docker run --rm --entrypoint cat spring-native-serverless /home/application/function.zip > build/function.zip

sam local start-api -t sam.yaml -p 3000
