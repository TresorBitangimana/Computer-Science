#! /bin/bash

if ! [[ -x hfzip ]]; then
    echo "hfzip executable does not exist"
    exit 1
fi

../../tester/run-tests.sh $*


