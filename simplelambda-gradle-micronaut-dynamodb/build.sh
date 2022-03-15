#!/bin/bash

docker build -t simplelambda-gradle-micronaut-dynamodb .
docker run --rm --entrypoint cat simplelambda-gradle-micronaut-dynamodb /home/application/function.zip > build/function.zip