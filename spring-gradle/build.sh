#!/bin/bash

./gradlew bootBuildImage
docker build -t spring-gradle-function .
docker run --rm --entrypoint cat spring-gradle-function /function.zip > build/function.zip