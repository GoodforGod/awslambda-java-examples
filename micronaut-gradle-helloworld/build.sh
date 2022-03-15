#!/bin/bash

docker build -t micronaut-gradle-helloworld.
docker run --rm --entrypoint cat micronaut-gradle-helloworld/home/application/function.zip > build/function.zip
