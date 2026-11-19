#! /bin/bash

if ! [[ -x hfcat ]]; then
    echo "hfcat executable does not exist"
    exit 1
fi

../../tester/run-tests.sh $*


