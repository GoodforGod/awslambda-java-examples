#!/bin/bash

docker build -t simple-gradle-native-lambda .
mkdir -p build
docker run --rm --entrypoint cat simple-gradle-native-lambda /home/application/function.zip > build/function.zip

sam local start-api -t sam.yaml -p 3000
