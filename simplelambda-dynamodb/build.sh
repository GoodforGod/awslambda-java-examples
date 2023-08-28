#!/bin/bash

docker build -t simplelambda-dynamodb .
docker run --rm --entrypoint cat simplelambda-dynamodb /home/application/function.zip > build/function.zip