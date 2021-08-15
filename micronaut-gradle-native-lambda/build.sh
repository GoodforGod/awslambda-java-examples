#!/bin/bash

./gradlew shadorJar
docker build -t micronaut-gradle-native-lambda .
docker run --rm --entrypoint cat micronaut-gradle-native-lambda /home/application/function.zip > build/function.zip
