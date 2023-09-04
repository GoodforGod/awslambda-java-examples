#!/bin/bash

../gradlew quarkus-helloworld:build -Dquarkus.package.type=native -Dquarkus.native.container-build=true