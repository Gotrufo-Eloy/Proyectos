public class Main {
    public static void main(String[] args) {
        Circulo circulo1 = new Circulo();
        circulo1.radio = 10;
        System.out.println(circulo1.calcularArea());
        System.out.println(circulo1.calcularPerimetro());
    }
}