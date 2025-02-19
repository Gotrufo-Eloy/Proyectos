import java.util.Scanner;

public class Pt1 {
    public static void main(String[] args) {
        Scanner miScanner = new Scanner(System.in);

        // Consumo diario en kWh = (Potencia en vatios / 1000) * Número de horas de
        // usodiario
        // Consumo mensual en kWh = Consumo diario en kWh * 30
        int numeroElectrodomesticos;
        System.out.println("Introduce el número de electrodomésticos a registrar:");
        numeroElectrodomesticos = miScanner.nextInt();
        double precioKilovatioHora;
        precioKilovatioHora = miScanner.nextDouble();
        int potenciaTotalContratada;
        potenciaTotalContratada = miScanner.nextInt();

        int potenciaConsumida = 0;
        int numeroHorasUso = 0;

        for (int i = 0; i < numeroElectrodomesticos; i++) {
            System.out.println("Introduce la potencia del electrodoméstico " + (i + 1));
            int potenciaElectrodomestico = miScanner.nextInt();
            ;
            if (potenciaConsumida + potenciaElectrodomestico > potenciaTotalContratada) {
                System.out.println("¡Alerta! Has superado la potencia de [potencia contratada] W.");
                i--;
            } else {
                potenciaConsumida += potenciaElectrodomestico;
                System.out.println("Introduce el número de horas de uso diario:");
                numeroHorasUso += miScanner.nextInt();
            }
        }
        int consumoTotalMensual= potenciaConsumida/1000*numeroHorasUso*30;
        double costeMensual = consumoTotalMensual*precioKilovatioHora;

        System.out.println("Consumo total mensual:"+consumoTotalMensual);
        System.out.println("Coste total mensual:"+costeMensual);
    }
}
