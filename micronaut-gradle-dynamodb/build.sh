#!/bin/bash

docker build -t micronaut-gradle-dynamodb .
docker run --rm --entrypoint cat micronaut-gradle-dynamodb /home/application/function.zip > build/function.zip
