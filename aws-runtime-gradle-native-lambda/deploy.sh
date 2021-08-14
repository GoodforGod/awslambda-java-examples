#!/bin/bash

docker build -t aws-runtime-gradle-native-lambda .
mkdir -p build
docker run --rm --entrypoint cat aws-runtime-gradle-native-lambda /home/application/function.zip > build/function.zip

sam local start-api -t sam.yaml -p 3000
