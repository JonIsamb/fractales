#!/bin/bash

if [ ! -d "../generalisationMandelbrot" ];then
  mkdir ../generalisationMandelbrot
fi

while getopts x:y:p: param
do
    case "${param}" in
      x) focusX=${OPTARG};;
      y) focusY=${OPTARG};;
      p) palette=${OPTARG};;
    esac
done


java -jar ../build/libs/sae-2022-2023.jar -f 'gm' -h 2048 -n 50 -o '../generalisationMandelbrot/generalisationMandelbrot.png' -p "$palette" -s 0.0007 -w 2048 -x $focusX -y $focusY



