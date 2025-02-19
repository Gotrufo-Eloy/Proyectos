import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner miScanner = new Scanner(System.in);
        int numero;
        // boolean entre10y20;

        System.out.println("Introduzca un número: ");
        numero = miScanner.nextInt();

        // entre10y20 = (numero <= 20 && numero >= 10);

        if (numero <= 20 && numero >= 10 ){
            System.out.println("El numero esta entre 10 y 20");
        }else {
            System.out.println("El numero NO ESTA ENTRE 10 Y 20");
        }

        miScanner.close();
    }
}
