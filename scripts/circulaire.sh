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

focus=( $focusX $focusY )
for par in "${focus[@]}"
do
  if [[ $par =~ ^[+-]?[0-9]+$ ]] || [[ $n =~ ^[+-]?[0-9]*\.?[0-9]+$ ]];then
    java -jar ../build/libs/sae-2022-2023.jar -f 'cc' -h 1080 -n 124 -o '../circulaire/circulaire.png' -p "$palette" -s 1 -w 1080 -x $focusX -y $focusY
  else
    echo "Mauvais arguments, des paramètres par défaut ont été utilisés.";
    java -jar ../build/libs/sae-2022-2023.jar -f 'cc' -h 1080 -n 124 -o '../circulaire/circulaire.png' -p "$palette" -s 1 -w 1080 -x 0 -y 0
  fi
done

