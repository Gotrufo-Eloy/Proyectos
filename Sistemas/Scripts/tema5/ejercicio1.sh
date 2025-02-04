#!/bin/bash

convertir_temperatura() {
  temperatura=$1
  unidad=$2
  mensaje=""  

  if [ -z "$temperatura" ] || [ -z "$unidad" ]; then
    mensaje="Uso: convertir_temperatura <temperatura> <C|F>"
  elif [ "$unidad" = "C" ]; then
    resultado=$(( (temperatura - 32) * 5 / 9 ))
    mensaje="${temperatura}°F equivale a ${resultado}°C"
  elif [ "$unidad" = "F" ]; then
    resultado=$(( (temperatura * 9 / 5) + 32 ))
    mensaje="${temperatura}°C equivale a ${resultado}°F"
  else
    mensaje="Unidad no válida. Usa 'C' para Celsius o 'F' para Fahrenheit."
  fi

  echo "$mensaje"
}

convertir_temperatura "$@"