#!/bin/bash

../gradlew simplelambda-helloworld:shadowJar
docker build -t simplelambda-helloworld .
docker run --rm --entrypoint cat simplelambda-helloworld /home/application/function.zip > build/function.zip