#!/bin/bash
password=$1
while [ "$password" != 1234 ]; do 
    echo "Intoduce Contraseña"
    read password
done
echo "Contraseña correcta: $password"