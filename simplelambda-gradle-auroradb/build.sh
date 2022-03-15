#!/bin/bash

#docker build -t simplelambda-gradle-auroradb . --progress=plain
docker run --rm --entrypoint cat simplelambda-gradle-auroradb /home/application/function.zip > build/function.zip
