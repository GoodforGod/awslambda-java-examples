#!/bin/bash

./gradlew shadorJar
docker build -t micronaut-gradle-sql .
docker run --rm --entrypoint cat micronaut-gradle-sql /home/application/function.zip > build/function.zip
