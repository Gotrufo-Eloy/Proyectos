public class ClaseAuto {
    String marca;
    String modelo;
    double velocidadActual;
    double acelerar(double cantidad){
        return velocidadActual-=cantidad;
    }
    double frenar(double cantidad){
        return velocidadActual-=cantidad;
    }
}
