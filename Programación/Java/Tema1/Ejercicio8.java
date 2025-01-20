import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner miScanner = new Scanner(System.in);
        int numeroNiños;
        int numeroCaramelos;
        int caramelosPorNiño;
        int caramelosRestantes;

        System.out.println("Numero niños");
        numeroNiños = miScanner.nextInt();

        System.out.println("Numero Caramelos");
        numeroCaramelos = miScanner.nextInt();

        caramelosPorNiño = numeroCaramelos / numeroNiños; // Esto me devuelve siempre un entero
        caramelosRestantes = numeroCaramelos % numeroNiños;

        System.out.println("Numero de caramelos por niño: " + caramelosPorNiño);
        System.out.println("Numero de caramelos Restantes: "+caramelosRestantes);

        miScanner.close();

    }

}
