#!/bin/bash

docker build -t micronaut-gradle-function-helloworld .
docker run --rm --entrypoint cat micronaut-gradle-function-helloworld /home/application/function.zip > build/function.zip
