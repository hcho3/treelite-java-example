#!/bin/bash

set -x
# check out latest treelite repository
git clone --recursive https://github.com/dmlc/treelite
cd treelite
# build
if [ -d "build" ]
then
  rm -rf build
fi
mkdir build
cd build
cmake ..
make -j4

set +x
