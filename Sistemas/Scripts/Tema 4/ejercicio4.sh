#!/bin/bash
nombres=("Juan" "Eloy" "Maria")
apellidos=("Lopez" "Delgado" "Martinez")

for ((i=0; i<${#nombres[@]};i++)); do 
    completo[i]="${nombres[i]} ${apellidos[i]} - "
done
echo "Nombres : ${completo[@]}"