#!/bin/bash

docker build -t simplelambda-gradle-micronaut-helloworld .
docker run --rm --entrypoint cat simplelambda-gradle-micronaut-helloworld /home/application/function.zip > build/function.zip