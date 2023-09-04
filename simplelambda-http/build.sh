#!/bin/bash

../gradlew simplelambda-http:shadowJar
docker build -t simplelambda-http .
docker run --rm --entrypoint cat simplelambda-http /home/application/function.zip > build/function.zip