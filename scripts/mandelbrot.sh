#!/bin/bash

if [ ! -d "../mandelbrot" ];then
  mkdir ../mandelbrot
fi

while getopts x:y:p: param
do
    case "${param}" in
      x) focusX=${OPTARG};;
      y) focusY=${OPTARG};;
      p) palette=${OPTARG};;
    esac
done


java -jar ../build/libs/sae-2022-2023.jar -f 'm' -h 1000 -n 30 -o '../mandelbrot/mandelbrot.png' -p "$palette" -s 0.0027 -w 1000 -x $focusX -y $focusY



