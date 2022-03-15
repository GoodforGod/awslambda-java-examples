#!/bin/bash

./gradlew bootBuildImage
docker build -t spring-gradle-helloworld .
docker run --rm --entrypoint cat spring-gradle-helloworld /function.zip > build/function.zip