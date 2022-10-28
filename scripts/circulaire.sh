#!/bin/bash

if [ ! -d "../circulaire" ];then
  mkdir ../circulaire
fi

while getopts x:y:p: param
do
    case "${param}" in
      x) focusX=${OPTARG};;
      y) focusY=${OPTARG};;
      p) palette=${OPTARG};;
    esac
done


java -jar ../build/libs/sae-2022-2023.jar -f 'cc' -h 1000 -n 124 -o '../circulaire/circulaire.png' -p "$palette" -s 0.001 -w 1000 -x $focusX -y $focusY



