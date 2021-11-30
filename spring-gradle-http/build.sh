#!/bin/bash

./gradlew bootBuildImage
docker build -t spring-gradle-http-function .
docker run --rm --entrypoint cat spring-gradle-http-function /function.zip > build/function.zip