#!/bin/bash

../gradlew micronaut-application-helloworld:shadowJar
docker build -t micronaut-application-helloworld .
docker run --rm --entrypoint cat micronaut-application-helloworld /home/application/function.zip > build/function.zip
