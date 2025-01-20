import java.util.Scanner;

public class Rel4Ej4 {
    public static void main(String[] args) {
        Scanner miScanner = new Scanner(System.in);

        int combustibleDisponible;
        System.out.println("Introduce el combustible inicial:");
        combustibleDisponible= miScanner.nextInt();

        double precioLitro;
        System.out.println("Precio del litro de combustible:");
        precioLitro= miScanner.nextDouble();

        double consumo100Km;
        System.out.println("Consumo cada 100km:");
        consumo100Km= miScanner.nextDouble();


        int kmViaje;
        int iteraciones=1;

        while (combustibleDisponible>0) {
            System.out.println("Introduce los kilómetros del viaje"+iteraciones);
            kmViaje= miScanner.nextInt();
            if (kmViaje*consumo100Km/100>combustibleDisponible){
                System.out.println("Combustible Insuficiente");
            }else{
                iteraciones++;
                combustibleDisponible -= kmViaje*consumo100Km/100;
                System.out.println("Precio del viaje:" +kmViaje*consumo100Km/100*precioLitro);
                System.out.println("Combustible Restante:"+combustibleDisponible);
            }
        }
    }
}
