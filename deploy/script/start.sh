#!/bin/bash
java -Djava.security.egd=file:/dev/./urandom -Dspring.profile.active=prod \
-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap \
-XX:+UseG1GC -Xmx1500m -Xms1500m -XX:MaxGCPauseMillis=200 \
-XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -XX:+PrintHeapAtGC -Xloggc:log/gc-%t.log \
-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/log -jar /app.jar