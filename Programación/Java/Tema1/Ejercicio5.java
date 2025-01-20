import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner miScanner = new Scanner(System.in);
        double pesoEnLaTierra;
        double pesoEnLaLuna;

        System.out.println("Introduzca su peso: ");
        pesoEnLaTierra = miScanner.nextDouble();
        
        pesoEnLaLuna = pesoEnLaTierra * 0.165;
        System.out.println("En la Luna pesarías: " + pesoEnLaLuna + "kg.");
        
        miScanner.close();
    }
}