#!/bin/bash

../gradlew micronaut-application-dynamodb:shadowJar
docker build -t micronaut-application-dynamodb .
docker run --rm --entrypoint cat micronaut-application-dynamodb /home/application/function.zip > build/function.zip
