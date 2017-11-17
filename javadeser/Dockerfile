FROM centos
# FROM ubuntu

ADD jdk-8u11-linux-x64.rpm jdk-8u11-linux-x64.rpm

RUN yum localinstall -y jdk-8u11-linux-x64.rpm

# RUN apk add --update \
#     curl \
#     openjdk8=8.92.14-r0 \
# 	&& rm /var/cache/apk/* 
# RUN apt-get update && \
#   apt-get install -y openjdk-8-jdk && \
#   rm -rf /var/lib/apt/lists/*

ENV JAVA_HOME /usr/java/default/
#ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
VOLUME /tmp
ADD build/libs/jdeser-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""

EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS  -jar /app.jar
