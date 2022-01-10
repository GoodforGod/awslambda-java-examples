#!/bin/bash

./gradlew shadowJar
docker build -t simplelambda-gradle-micronaut .
docker run --rm --entrypoint cat simplelambda-gradle-micronaut /home/application/function.zip > build/function.zip