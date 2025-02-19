#!/bin/bash



contarArchivos(){
    directorio=$1
    mensaje=""

    if [ ! -d "$directorio" ]; then
        mensaje="Error:El directorio no existe"
    else
        cantidad=$(find "$directorio" -type f | wc -l)
        mensaje="El directorio: $directorio contiene $cantidad de archivos"
    fi



    echo "$mensaje"
}

contarArchivos "."