import java.util.Scanner;

public class Rel4Ej3 {
    public static void main(String[] args) {
        Scanner miScanner = new Scanner(System.in);
        int precioTotal =0;
        int numeroPersonas;
        int porcentajePropina;
        int input = 1;
        int numeroProducto = 0;

        while (input != 0) {
            numeroProducto++;
            System.out.println("Precio del producto " + numeroProducto);
            input = miScanner.nextInt();
            precioTotal += input;
        }
        System.out.println("¿Cuánta propina quieres dejar? (%)");
        porcentajePropina = miScanner.nextInt();
        System.out.println("¿Cúantas personas sois?");
        numeroPersonas = miScanner.nextInt();

        double precioTrasPropina = (precioTotal * porcentajePropina / 100 + precioTotal);
        System.out.println("Total sin propina: " + precioTotal);
        System.out.println("Total con propina del " + porcentajePropina + "%: " + precioTrasPropina);
        System.out.println("Precio por cabeza:" + precioTrasPropina / numeroPersonas);
        miScanner.close();
    }
}
