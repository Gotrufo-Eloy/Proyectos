#!/bin/bash

validarContraseña(){
    mensaje="Menos de 8 caracteres"
    if [[${#1} -lt 8]] || ! [[ "$1" =~ [A-Z] ]] || ! [[ "$1" =~ [0-9] ]]; then 
        mensaje="Contraseña válida."
    fi
    echo "$mensaje"
}

validarContraseña "MiCl123"