#!/bin/bash

docker build -t micronaut-gradle-http .
docker run --rm --entrypoint cat micronaut-gradle-http /home/application/function.zip > build/function.zip
