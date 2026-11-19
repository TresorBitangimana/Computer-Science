#! /bin/bash

if ! [[ -x hfgrep ]]; then
    echo "hfgrep executable does not exist"
    exit 1
fi

../../tester/run-tests.sh $*



