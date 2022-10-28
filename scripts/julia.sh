#!/bin/bash

if [ ! -d "../julia" ];then
  mkdir ../julia
fi

while getopts x:y:p: param
do
    case "${param}" in
      x) focusX=${OPTARG};;
      y) focusY=${OPTARG};;
      p) palette=${OPTARG};;
    esac
done


java -jar ../build/libs/sae-2022-2023.jar -f 'j' -h 1080 -n 200 -o '../julia/julia.png' -p "$palette" -s 0.003 -w 1080 -x $focusX -y $focusY



