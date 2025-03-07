package PT5Base;
import java.util.ArrayList;

public class Almancen {
    int id;
    ArrayList<Producto> Productos;

    public Almacen(){
    }

    public Producto buscarProductoPorCodigo(String codigo){
        Producto productoBuscado;
        for (int i = 0; i < Productos.size(); i++) {
            if(Productos.get(i).getCodigo().equalsIgnoreCase(codigo)){
                productoBuscado = Productos.get(i);
            }
        }
        return productoBuscado;
    }

    public int agregarStockAProducto(String codigo, int cantidadAñadir){
        Producto producto = buscarProductoPorCodigo(codigo);
        int nuevaCantidadTotal = producto.getCantidad()+cantidadAñadir;
        producto.setCantidad(nuevaCantidadTotal);
        return producto.getCantidad();
    }

    public int retirarStockAProducto(String codigo, int cantidadQuitar){
        Producto producto = buscarProductoPorCodigo(codigo);
        int nuevaCantidadTotal = producto.getCantidad()-cantidadQuitar;
        producto.setCantidad(nuevaCantidadTotal);
        return producto.getCantidad();
    }

    public void eliminarProducto(String codigo){
        Producto productoBuscado;
        for (int i = 0; i < Productos.size(); i++) {
            if(Productos.get(i).getCodigo().equalsIgnoreCase(codigo)){
                Productos.remove(i);
            }
        }
    }

    public String toString(){
        String line = "";
        for (int i = 0; i < Productos.size(); i++) {
            line+=Productos.get(i)+"\n";
        }
        return line;
    }
}
