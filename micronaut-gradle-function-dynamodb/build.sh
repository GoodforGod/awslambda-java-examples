#!/bin/bash

docker build -t micronaut-gradle-function-dynamodb .
docker run --rm --entrypoint cat micronaut-gradle-function-dynamodb /home/application/function.zip > build/function.zip
