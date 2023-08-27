#!/bin/bash

../gradlew spring-gradle-helloworld:bootBuildImage
docker build -t spring-gradle-helloworld-function .
docker run --rm --entrypoint cat spring-gradle-helloworld-function function.zip > build/function.zip