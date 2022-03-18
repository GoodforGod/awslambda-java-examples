#!/bin/bash

docker build -t micronaut-gradle-application-http .
docker run --rm --entrypoint cat micronaut-gradle-application-http /home/application/function.zip > build/function.zip
