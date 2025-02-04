#!/bin/bash

#crea un scrip con dos args una asignatura y una pt1 el programa dice hola y que va a crear una asignatura y un dir con la pt 

echo "Hola $user"
echo "voy a crear un directorio para la asignatura $1"
echo "Voy a crear un subdirectorio para la $2"
mkdir $1
mkdir -p /$1/$2