#!/bin/bash
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/
mvn -Duser.name=build clean package
wget -nc https://api.papermc.io/v2/projects/waterfall/versions/1.13/builds/276/downloads/waterfall-1.13-276.jar -O waterfall.jar
wget -nc https://api.papermc.io/v2/projects/paper/versions/1.13/builds/173/downloads/paper-1.13-173.jar -O paper.jar
docker-compose up --force-recreate -t 0 -d
if [ $# -gt 0 ]
  then
    docker attach commandcentral_$1_1
fi
