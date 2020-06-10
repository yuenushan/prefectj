#!/bin/bash
java -Djava.security.egd=file:/dev/./urandom -Dspring.profile.active=prod \
-XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -XX:+PrintHeapAtGC -Xloggc:log/gc-%t.log \
-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/log -jar /app.jar