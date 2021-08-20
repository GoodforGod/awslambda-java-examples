#!/bin/bash

./gradlew shadorJar
docker build -t micronaut-http-gradle-native-lambda .
docker run --rm --entrypoint cat micronaut-http-gradle-native-lambda /home/application/function.zip > build/function.zip
