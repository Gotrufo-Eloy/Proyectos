 #!/bin/bash

if [ $# -lt 2 ]; then
    echo "Uso: $0 <nombre> <apodo>"
    exit 1
fi
nombre=$1
apodo=$2

iteraciones=0

listaDeProyectos=("proyecto1" "proyecto2" "proyecto3" "proyecto4" "proyecto5")
 
echo "Bienvenido a la Configuración de Sistema Linux"
echo "¡Hola, $nombre! También conocido como $apodo."

echo "Creando usuarios iniciales..."
#useradd admin1
echo "- Usuario 'admin1' creado."
#useradd dev1
echo "- Usuario 'dev1' creado."
#useradd design1
echo "- Usuario 'design1' creado."
echo "Configuración inicial completada."

echo "Configurando directorios..."
mkdir proyectos
echo "- Directorio '/proyectos' creado."
chmod 700 proyectos 
echo "- Permisos asignados correctamente."

while [ "$opcion" != "7" ]; do  
    clear
    echo -e "\nMenú Principal:"
    echo "1. Mostrar el árbol de directorios desde la raíz"
    echo "2. Ver directorios creados y sus permisos"
    echo "3. Crear un nuevo usuario"
    echo "4. Mostrar un directorio del array predefinido de directorios compartidos"
    echo "5. Mostrar el usuario actual y su directorio personal"
    echo "6. Listar todos los elementos del array predefinido"
    echo "7. Salir"
    read -p "Selecciona una opción (1-7): " opcion

    if [ "$opcion" = "1" ]; then
        tree /
    elif [ "$opcion" = "2" ]; then  
        echo "Directorios creados y permisos:"
        ls -d -l
    elif [ "$opcion" = "3" ]; then  
        read "Ingresa el nombre del nuevo usuario:" nuevoUsuario
        useradd $nuevoUsuario
        echo "Usuario $nuevoUsuario creado."
    elif [ "$opcion" = "4" ]; then  
        numeroAleatorio=$((RANDOM % ${#listaDeProyectos[@]})) 
        echo "Directorio "seleccionado" del array:"
        echo ${listaDeProyectos[numeroAleatorio]}
    elif [ "$opcion" = "5" ]; then  
        echo "Usuario actual: $USER"
        echo "Directorio personal: $HOME"
    elif [ "$opcion" = "6" ]; then  
        for ((i=1; i<=${#listaDeProyectos[@]};i++)); do
            echo $i
        done
    elif [ "$opcion" = "7" ]; then  
        echo "Has seleccionado $iteraciones opciones del menú. Gracias por usar el configurador de sistema. ¡Hasta pronto!"
    else  
        echo "INPUT INCORRECTO"
        $iteraciones=$iteraciones-1
    fi
    $iteraciones=$iteraciones+1
done

