#!/bin/bash

set -e
mvn -DskipTests clean package
docker compose build
docker compose up -d