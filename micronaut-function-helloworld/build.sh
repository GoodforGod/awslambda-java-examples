#!/bin/bash

../gradlew micronaut-function-helloworld:shadowJar
docker build -t micronaut-function-helloworld .
docker run --rm --entrypoint cat micronaut-function-helloworld /home/application/function.zip > build/function.zip
