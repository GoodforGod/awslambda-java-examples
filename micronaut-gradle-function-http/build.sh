#!/bin/bash

docker build -t micronaut-gradle-function-http .
docker run --rm --entrypoint cat micronaut-gradle-function-http /home/application/function.zip > build/function.zip
