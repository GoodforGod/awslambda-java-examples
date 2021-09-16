#!/bin/bash

./gradlew shadorJar
docker build -t simple-gradle-native-lambda .
docker run --rm --entrypoint cat simple-gradle-native-lambda /home/application/function.zip > build/function.zip