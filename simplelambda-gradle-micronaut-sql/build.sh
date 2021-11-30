#!/bin/bash

./gradlew shadorJar
docker build -t simplelambda-gradle-micronaut-sql .
docker run --rm --entrypoint cat simplelambda-gradle-micronaut-sql /home/application/function.zip > build/function.zip