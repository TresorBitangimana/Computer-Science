#! /bin/bash

if ! [[ -x hfunzip ]]; then
    echo "hfunzip executable does not exist"
    exit 1
fi

../../tester/run-tests.sh $*


