#!/bin/bash

docker build -t simplelambda-gradle-helloworld .
docker run --rm --entrypoint cat simplelambda-gradle-helloworld /home/application/function.zip > build/function.zip