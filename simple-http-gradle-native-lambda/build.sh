#!/bin/bash

./gradlew shadorJar
docker build -t simple-http-gradle-native-lambda .
docker run --rm --entrypoint cat simple-http-gradle-native-lambda /home/application/function.zip > build/function.zip