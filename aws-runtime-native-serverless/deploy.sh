#!/bin/bash

docker build -t aws-runtime-native-serverless .
mkdir -p build
docker run --rm --entrypoint cat aws-runtime-native-serverless /home/application/function.zip > build/function.zip

# sam local start-api -t sam.yaml -p 3000
