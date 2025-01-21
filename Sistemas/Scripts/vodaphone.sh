#!/bin/bash

echo "Bienvenido al chatBot"
read -p "Introduce tu nombre " nombre
read -p "Introduce tu apellido " apellido 
echo "Hola $nombre $apellido"
opcion="a"
while [ "$opcion" != "d" ]; do
    read -p "a Consultar saldo. 
b Activar un bono de datos. 
c Hablar con soporte técnico.
d Salir.
Introduce tu opcion: " opcion
    if [ "$opcion" = "a" ]; then
        saldo=$((RANDOM % 50)) 
        echo "Tu saldo es: $saldo"
    elif [ "$opcion" = "b" ]; then
        read -p "Bono 1GB: 5 euros.
        Bono 5GB: 15 euros.
        Bono 10GB: 25 euros." opcionBono
    elif [ "$opcion" = "c" ]; then
        read -p "introduce tu respuesta"
        echo "Gracias por tu mensaje, un agente te contactará pronto"
    elif [ "$opcion" = "d" ]; then
        echo "Un placer haber ayudado"
    else 
        echo "opcion incorrecta"
    fi
done