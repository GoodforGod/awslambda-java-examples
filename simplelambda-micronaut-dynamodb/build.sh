#!/bin/bash

../gradlew simplelambda-micronaut-dynamodb:shadowJar
docker build -t simplelambda-micronaut-dynamodb .
docker run --rm --entrypoint cat simplelambda-micronaut-dynamodb /home/application/function.zip > build/function.zip