#!/bin/bash

if [ ! -d "../juliaSuccessifs" ];then
  mkdir ../juliaSuccessifs
fi

while getopts x:y:p: param
do
    case "${param}" in
      x) focusX=${OPTARG};;
      y) focusY=${OPTARG};;
      p) palette=${OPTARG};;
    esac
done

scale=1
debutPath="../juliaSuccessifs/juliaSuccessifs-"
finPath=".png"

for i in {0..4};
  do
    java -jar ../build/libs/sae-2022-2023.jar -f 'j' -h 1080 -n 200 -o "$debutPath$i$finPath" -p "$palette" -s $scale -w 1080 -x $focusX -y $focusY
    scale=$(bc -l <<< $scale/10)
  done



