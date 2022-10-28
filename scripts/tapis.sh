#!/bin/bash

if [ ! -d "../tapis" ];then
  mkdir ../tapis
fi

while getopts h:w:n: param
do
    case "${param}" in
      h) height=${OPTARG};;
      w) width=${OPTARG};;
      n) nbIterations=${OPTARG};;
    esac
done


java -jar ../build/libs/sae-2022-2023.jar -f 'tapis' -h $height -n $nbIterations -o '../tapis/tapis.svg' -p 'p' -s 0.001 -w $width -x 0 -y 0



