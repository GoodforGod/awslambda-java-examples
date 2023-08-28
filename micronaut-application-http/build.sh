#!/bin/bash

docker build -t micronaut-application-http .
docker run --rm --entrypoint cat micronaut-application-http /home/application/function.zip > build/function.zip
