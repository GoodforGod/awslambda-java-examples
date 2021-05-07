#!/bin/bash

docker build -t micronaut-native-serverless .
mkdir -p build
docker run --rm --entrypoint cat micronaut-native-serverless /home/application/function.zip > build/function.zip

sam local start-api -t sam.yaml -p 3000
