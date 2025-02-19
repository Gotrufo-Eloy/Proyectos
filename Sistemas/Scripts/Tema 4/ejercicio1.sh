#!/bin/bash
edad=$1

if [ $edad -lt 18 ]; then
    echo "Eres menor de edad"
elif [ $edad -le 65 ]; then
    echo "Eres Adulto"
else 
    echo "Eres mayor"
fi