#!/bin/bash

../gradlew simplelambda-micronaut-http:shadowJar
docker build -t simplelambda-micronaut-http .
docker run --rm --entrypoint cat simplelambda-micronaut-http /home/application/function.zip > build/function.zip