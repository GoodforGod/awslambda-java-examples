#!/bin/bash

../gradlew spring-http:bootBuildImage
docker build -t spring-http-function .
docker run --rm --entrypoint cat spring-http-function function.zip > build/function.zip
