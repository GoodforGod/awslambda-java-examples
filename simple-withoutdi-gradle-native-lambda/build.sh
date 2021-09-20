#!/bin/bash

./gradlew shadorJar
docker build -t simple-withoutdi-gradle-native-lambda .
docker run --rm --entrypoint cat simple-withoutdi-gradle-native-lambda /home/application/function.zip > build/function.zip