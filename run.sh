#!/bin/bash

# https://unix.stackexchange.com/questions/129391/passing-named-arguments-to-shell-scripts

for ARGUMENT in "$@"
do
   KEY=$(echo $ARGUMENT | cut -f1 -d=)

   KEY_LENGTH=${#KEY}
   VALUE="${ARGUMENT:$KEY_LENGTH+1}"

   export "$KEY"="$VALUE"
done

java lexi.Main