FROM java:8-jdk-alpine
MAINTAINER beeeeeeenny <beeeeeeenny@gmail.com>

ENV BASE_WORK=/code

# maven env
ENV MAVEN_VERSION=3.5.2
ENV MAVEN_HOME=/usr/lib/mvn
ENV PATH=$MAVEN_HOME/bin:$PATH

# tomcat env
ENV TOMCAT_MAJOR=8
ENV TOMCAT_VERSION=8.5.3
ENV TOMCAT_HOME=/opt/tomcat/apache-tomcat-${TOMCAT_VERSION}
ENV CATALINA_HOME=/opt/tomcat/apache-tomcat-${TOMCAT_VERSION}
ENV PATH=$CATALINA_HOME/bin:$PATH
ENV CATALINA_OUT=/dev/null

# war package
ENV PACKAGE_VERSION=1.0

# dockerize env
ENV DOCKERIZE_VERSION=v0.6.0

COPY . $BASE_WORK/novel-server

RUN apk upgrade --update && \
    apk add wget python python-dev py-pip musl-dev gcc py-curl py-mysqldb openssl openssl-dev libxml2-dev libxslt-dev libffi-dev libxml2 libxslt && \

    wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz && \
    tar -C /usr/local/bin -xzvf dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz && \
    rm dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz && \

    pip install --no-cache-dir -r $BASE_WORK/novel-server/novel/requirements.txt && \

    wget http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz && \
    tar -zxvf apache-maven-$MAVEN_VERSION-bin.tar.gz && \
    rm apache-maven-$MAVEN_VERSION-bin.tar.gz && \
    mv apache-maven-$MAVEN_VERSION /usr/lib/mvn && \

    wget http://archive.apache.org/dist/tomcat/tomcat-${TOMCAT_MAJOR}/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz && \
    mkdir -p $TOMCAT_HOME && \
    mv apache-tomcat-${TOMCAT_VERSION}.tar.gz $TOMCAT_HOME && \
    cd $TOMCAT_HOME && \
    tar -zxvf apache-tomcat-${TOMCAT_VERSION}.tar.gz && \
    mv $TOMCAT_HOME/apache-tomcat-${TOMCAT_VERSION}/* $TOMCAT_HOME && \
    rm -rf ${TOMCAT_HOME}/webapps/* && \

    apk del wget python-dev musl-dev gcc openssl-dev libxml2-dev libxslt-dev libffi-dev && \
    rm -rf apache-tomcat-${TOMCAT_VERSION}.tar.gz $TOMCAT_HOME/apache-tomcat-${TOMCAT_VERSION} /var/cache/apk/* && \

    cd $BASE_WORK/novel-server && \
    mvn package -Dmaven.test.skip=true && \
    chmod 755 $BASE_WORK/novel-server/target/novel-server-$PACKAGE_VERSION.war && \
    cd ${TOMCAT_HOME}/webapps && \
    mkdir ROOT && \
    mv $BASE_WORK/novel-server/target/novel-server-$PACKAGE_VERSION.war ${TOMCAT_HOME}/webapps/ROOT && \
    cd ROOT && \
    jar xvf novel-server-$PACKAGE_VERSION.war

WORKDIR $BASE_WORK/novel-server

EXPOSE 8080

CMD ["sh", "-x", "run.sh"]


