#!/bin/bash

set -ex

dockerize -template /code/novel-server/template/config.properties.template:${TOMCAT_HOME}/webapps/ROOT/WEB-INF/classes/properties/config.properties
dockerize -template /code/novel-server/template/novel.properties.template:${TOMCAT_HOME}/webapps/ROOT/WEB-INF/classes/properties/novel.properties

catalina.sh run
