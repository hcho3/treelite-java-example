#!/bin/bash

set -x
# check out latest treelite repository
git clone --recursive https://github.com/dmlc/treelite
# switch to ast_refactor dev branch
cd treelite
git checkout ast_refactor
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
