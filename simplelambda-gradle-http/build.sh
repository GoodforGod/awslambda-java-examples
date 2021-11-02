#!/bin/bash

./gradlew shadorJar
docker build -t simplelambda-gradle-http .
docker run --rm --entrypoint cat simplelambda-gradle-http /home/application/function.zip > build/function.zip