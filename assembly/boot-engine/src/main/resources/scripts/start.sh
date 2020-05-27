#!/bin/bash
APP_EXECUTABLE="../lib/ap-p2p-sm-service-stubs-boot.jar"
CONFIG_PATH="../properties/application.yml"
SPRING_BOOT_OPTS="-Dspring.config.location=file:$CONFIG_PATH"
PID_FILE="ap-p2p-sm-service-stubs.pid"
./env.sh

java -jar $SPRING_BOOT_OPTS $APP_EXECUTABLE & echo $! > $PID_FILE