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


java -jar ../build/libs/sae-2022-2023.jar -f 'm' -h 1080 -n 30 -o '../generalisationMandelbrot/generalisationMandelbrot.png' -p "$palette" -s 0.0015 -w 1080 -x $focusX -y $focusY



