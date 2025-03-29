
import java.util.ArrayList;

public class Almacen {
    int id;
    ArrayList<Producto> Productos;

    public Almacen(){
        this.Productos = new ArrayList<>();
    }

    public Producto buscarProductoPorCodigo(String codigo){
        Producto productoBuscado = null;
        for (int i = 0; i < Productos.size(); i++) {
            if(Productos.get(i).getCodigo().equalsIgnoreCase(codigo)){
                productoBuscado = Productos.get(i);
            }
        }
        return productoBuscado;
    }

    public int buscarPosicionProductoPorCodigo(String codigo){
        int posicionProductoBuscado = -1;
        for (int i = 0; i < Productos.size(); i++) {
            if(Productos.get(i).getCodigo().equalsIgnoreCase(codigo)){
                posicionProductoBuscado = i;
            }
        }
        return posicionProductoBuscado;
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
