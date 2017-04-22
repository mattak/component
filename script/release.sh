#!/bin/sh

if [ -z "$BINTRAY_USER" -o -z "$BINTRAY_KEY" ]; then
  echo "set BINTRAY_USER or BINTRAY_KEY"
  exit 1
fi

./gradlew clean build bintrayUpload -PbintrayUser=$BINTRAY_USER -PbintrayKey=$BINTRAY_KEY -PdryRun=false
