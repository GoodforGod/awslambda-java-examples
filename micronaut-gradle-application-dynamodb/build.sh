#!/bin/bash

docker build -t micronaut-gradle-application-dynamodb .
docker run --rm --entrypoint cat micronaut-gradle-application-dynamodb /home/application/function.zip > build/function.zip
