#!/bin/bash

dir=$(dirname $(realpath $0))
cd $dir/../..
# echo $(bloop run console -- -r $@)
value=$(bloop run console -- -r $@)
echo $value | xclip -selection clipboard
echo $value
