#!/bin/bash

finPrograma=false 
targetNumber=$((RANDOM % 101)) 
intentos=0

while [ "$finPrograma" = false  ]; do
    echo "Introduce un numero entre 1 y 100 o SALIR" 
    read input
    # echo $targetNumber
    if [  "$input" = "SALIR" ]; then 
        finPrograma=true
        echo "Has salido del programa"
    else
            intentos=$((intentos+1))
        if [ "$input" = "$targetNumber" ]; then 
            finPrograma=true 
            echo "Has Ganado fin del juego"
            echo "Tu numero de intentos ha sido $intentos!"
        elif [  $input -gt $targetNumber ]; then 
            echo "El numero es menor que el que has introducido"
        else
            echo "El numero es mayor que el que has introducido"
        fi
    fi
done