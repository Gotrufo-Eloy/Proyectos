agregarProducto(){
if [ $# -ne 2 ];then
    echo "La funcion requiere 2 argumentos"
else 
    productoAgregado=$1
    cantidadProducto=$2
    echo "- $productoAgregado ($cantidadProducto unidades)">>inventario.txt
fi
}
mostrarProductos(){
    if [ -s inventario.txt ]; then
        echo "No hay productos en el inventario."
    else
        cat inventario.txt 
    fi
}
realizarPedido(){
if [ $# -lt 2 ];then
    echo "La funcion requiere 2 argumentos"
else
    contador=0
    while [ $contador -le (($# / 2)) ]; do
        pedido=$1
        cantidadPeido=$2
        echo "- $pedido ($cantidadPeido unidades)">>pedido.txt
        ((contador++))
        shift 2
    done
fi
}
listarPedidos(){
    if [ -s pedidos.txt ]; then
        echo "No hay productos en el inventario."
    else
        cat pedidos.txt 
    fi
}
touch inventario.txt
touch pedidos.txt

mostrarProductos
listarPedidos

agregarProducto "Silla LACK" 2 
realizarPedido "Silla LACK" 2 "Mesa MALM" 1 "Estantería KALLAX" 3

mostrarProductos
listarPedidos





