#!/bin/bash

if [ ! -d "../generalisationJulia" ];then
  mkdir ../generalisationJulia
fi

while getopts x:y:p: param
do
    case "${param}" in
      x) focusX=${OPTARG};;
      y) focusY=${OPTARG};;
      p) palette=${OPTARG};;
    esac
done


java -jar ../build/libs/sae-2022-2023.jar -f 'gj' -h 1080 -n 200 -o '../generalisationJulia/generalisationJulia.png' -p "$palette" -s 1 -w 1080 -x $focusX -y $focusY



