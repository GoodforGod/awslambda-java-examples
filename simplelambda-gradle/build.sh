#!/bin/bash

./gradlew shadorJar
docker build -t simplelambda-gradle .
docker run --rm --entrypoint cat simplelambda-gradle /home/application/function.zip > build/function.zip