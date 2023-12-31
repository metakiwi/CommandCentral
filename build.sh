#!/bin/bash
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/
mvn -Duser.name=build clean package
docker-compose up --force-recreate -t 0 -d
if [ $# -gt 0 ]
  then
    docker attach commandcentral_$1_1
fi
