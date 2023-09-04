#!/bin/bash

../gradlew simplelambda-micronaut-helloworld:shadowJar
docker build -t simplelambda-micronaut-helloworld .
docker run --rm --entrypoint cat simplelambda-micronaut-helloworld /home/application/function.zip > build/function.zip