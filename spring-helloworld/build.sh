#!/bin/bash

../gradlew spring-helloworld:bootBuildImage
docker build -t spring-helloworld-function .
docker run --rm --entrypoint cat spring-helloworld-function function.zip > build/function.zip