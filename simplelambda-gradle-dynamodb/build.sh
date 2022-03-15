#!/bin/bash

docker build -t simplelambda-gradle-dynamodb .
docker run --rm --entrypoint cat simplelambda-gradle-dynamodb /home/application/function.zip > build/function.zip