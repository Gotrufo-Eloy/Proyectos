package PT5Base;
public class Producto{
    String nombre;
    String codigo;
    int cantidad;
    double precio;

    public Producto(String nombre, String codigo, int cantidad, double precio){
        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String toString(){
        return "Codigo: "+this.codigo+" | Nombre: "+this.nombre+" | Cantidad: "+this.cantidad+" | Precio: "+this.precio+" €";
    }
    
}
