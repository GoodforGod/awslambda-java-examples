#!/bin/bash

./gradlew shadorJar
docker build -t micronaut-gradle .
docker run --rm --entrypoint cat micronaut-gradle /home/application/function.zip > build/function.zip
