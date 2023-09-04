#!/bin/bash

../gradlew micronaut-function-dynamodb:shadowJar
docker build -t micronaut-function-dynamodb .
docker run --rm --entrypoint cat micronaut-function-dynamodb /home/application/function.zip > build/function.zip
