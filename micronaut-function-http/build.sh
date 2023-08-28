#!/bin/bash

docker build -t micronaut-function-http .
docker run --rm --entrypoint cat micronaut-function-http /home/application/function.zip > build/function.zip
