#!/bin/bash

dir=$(dirname $(realpath $0))
cd $dir/../..
value=$(bloop run console -- $@)
echo $value | xclip -selection clipboard
echo $value
