/*
1. Registro de Temperatura Diaria
Escribe un programa que permita al usuario ingresar las temperaturas registradas durante una semana (7 días). Una vez ingresadas las temperaturas, el programa debe mostrar al usuario un menú con las siguientes opciones:

Mostrar la temperatura más alta registrada.
Mostrar la temperatura más baja registrada.
Calcular la temperatura promedio de la semana.
Salir del programa.
El programa debe ejecutarse hasta que el usuario elija la opción de salir. 
*/

package PruebasPropias.Java;
import java.util.Scanner;

public class ud2ej1 {
    public static void main(String[] args){
        Scanner miScanner = new Scanner(System.in);
        int[] temperaturas = {0,0,0,0,0,0,0};
        int imputUsuario = 0 ;

        for (int i = 0; i < 7; i++) {
            System.out.println("Temperatura del dia "+(i+1));
            temperaturas[i]=miScanner.nextInt();
        }
        while (imputUsuario!=4) {
            System.out.println("Elige una opcion \n1.-Temperatura más alta registrada\n2.-Temperatura más baja registrada\n3.-Temperatura promedio de la semana\n4.-Salir del programa");
            imputUsuario=miScanner.nextInt();
            if(imputUsuario == 1){
                int temperaturaMaxima;
                temperaturaMaxima = temperaturas[0];
                for (int i = 0; i < temperaturas.length; i++) {
                    if (temperaturaMaxima<temperaturas[i]){
                        temperaturaMaxima= temperaturas[i];
                    }
                }
                System.out.println("Temperatura Maxima: "+temperaturaMaxima);
            }else if (imputUsuario== 2){
                int temperaturaMinima;
                temperaturaMinima = temperaturas[0];
                for (int i = 0; i < temperaturas.length; i++) {
                    if (temperaturaMinima>temperaturas[i]){
                        temperaturaMinima= temperaturas[i];
                    }
                }
                System.out.println("Temperatura Minima: "+temperaturaMinima);
            }else if (imputUsuario== 3){
                double promedioSemana = 0;
                for (int i = 0; i < temperaturas.length; i++) {
                    promedioSemana+=temperaturas[i];
                }
                promedioSemana= promedioSemana/temperaturas.length;
                System.out.println("Temperatura Promedio: "+promedioSemana);
            }else if (imputUsuario==4){
                System.out.println("Adios puta");
            }else {
                System.out.println("Imput incorrecto.");
            }
        }
        miScanner.close();
    }
    
}
