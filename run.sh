#!/bin/bash

set -ex

dockerize -template /code/novel-server/template/config.properties.template:/code/novel-server/src/main/resources/properties/config.properties
dockerize -template /code/novel-server/template/novel.properties.template:/code/novel-server/src/main/resources/properties/novel.properties

catalina.sh run
