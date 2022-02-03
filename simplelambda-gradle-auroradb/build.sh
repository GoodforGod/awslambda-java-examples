#!/bin/bash

./gradlew shadorJar
docker build -t simplelambda-gradle-auroradb .
docker run --rm --entrypoint cat simplelambda-gradle-auroradb /home/application/function.zip > build/function.zip