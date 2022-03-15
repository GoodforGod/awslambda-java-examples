#!/bin/bash

docker build -t simplelambda-gradle-micronaut-http .
docker run --rm --entrypoint cat simplelambda-gradle-micronaut-http /home/application/function.zip > build/function.zip