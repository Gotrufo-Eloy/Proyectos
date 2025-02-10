#!/bin/bash
calculadora(){
    numero1=$1
    operador=$2
    numero2=$3
    mensaje="El resultado es"

    if [ "$operador" = "+" ]; then 
            solucion=$(($numero1 + $numero2))
        elif [  $operador = "-" ]; then 
            solucion=$(($numero1 - $numero2))
        elif [  $operador = "/" ]; then 
            solucion=$(($numero1 / $numero2))
        elif [  $operador = "\*" ]; then 
            solucion=$(($numero1 * $numero2))
        else
            mensaje="Operador Desconocido"
            solucion=""
        fi


    echo "$mensaje $solucion"
}

calculadora 1 "+" 2
calculadora 1 "-" 2
calculadora 1 "/" 2
calculadora 1 "\*" 2