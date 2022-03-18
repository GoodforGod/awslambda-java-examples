#!/bin/bash

docker build -t micronaut-gradle-application-helloworld .
docker run --rm --entrypoint cat micronaut-gradle-application-helloworld /home/application/function.zip > build/function.zip
