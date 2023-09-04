#!/bin/bash

../gradlew simplelambda-auroradb:shadowJar
docker build -t simplelambda-auroradb .
docker run --rm --entrypoint cat simplelambda-auroradb /home/application/function.zip > build/function.zip
