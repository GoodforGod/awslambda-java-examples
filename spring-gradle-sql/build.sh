#!/bin/bash

./gradlew bootBuildImage
docker build -t spring-gradle-sql-function .
docker run --rm --entrypoint cat spring-gradle-sql-function /function.zip > build/function.zip