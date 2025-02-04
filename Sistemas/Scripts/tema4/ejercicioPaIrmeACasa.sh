#!/bin/bash

touch espada_de_verdad.txt
echo "Una hoja brillante hecha para cortar la oscuridad." >> espada_de_verdad.txt
touch escudo_eterno.txt
echo "Un escudo que puede soportar cualquier ataque." >> escudo_eterno.txt
touch amuleto_del_destino.txt
echo "Un amuleto que concede visiones del futuro." >> amuleto_del_destino.txt

echo "Creando los artefactos sagrados del Mirror of Kalanda..."
echo "Artefactos creados:
amuleto_del_destino.txt
escudo_eterno.txt
espada_de_verdad.txt"

while [ "$opcion" != "2" ]; do
    echo "===== Mirror of Kalandra ====="
    echo "1. Leer las escrituras de los artefactos"
    echo "2. Destruir los artefactos y salir del mundo de Kalandra"
    echo "=============================="
    read opcion
    if [ "$opcion" = "1" ]; then
        echo "Elige una opción (1-2): $opcion"
        echo "=== Escrituras de los Artefactos ==="
        echo "Espada de Verdad:"
        cat espada_de_verdad.txt
        echo "Escudo Eterno:"
        cat escudo_eterno.txt
        echo "Amuleto del Destino:"
        cat amuleto_del_destino.txt
        echo "===================================="
    elif [ "$opcion" = "2" ]; then  
    echo "Elige una opción (1-2): $opcion"
    echo "Has elegido salir del mundo del Mirror of Kalandra."
    fi
done
echo "Destruyendo los artefactos sagrados..."
rm espada_de_verdad.txt
rm escudo_eterno.txt
rm amuleto_del_destino.txt
echo "Artefactos destruidos. Adiós al Mirror of Kalandra."