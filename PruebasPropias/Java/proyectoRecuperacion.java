package PruebasPropias.Java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class proyectoRecuperacion {
    public static ArrayList<Boolean> comprobacionInstalacionesYEnergia(int estadoMaximoInstalaciones, int costeDeEnergia,int energia, ArrayList<String> instalaciones ){
        boolean puedeCrearOxigeno = false;
        boolean error = false; 
        ArrayList<Boolean> bouleanosReturneados = new ArrayList<Boolean>();

        if (instalaciones.size()>estadoMaximoInstalaciones && energia < costeDeEnergia){
            System.out.println("No puedes generar oxigeno porque las instalaciones estan muy dañadas y no tienes suficiente energía");
            error = true;
        }else if (instalaciones.size()>estadoMaximoInstalaciones){
            System.out.println("No puedes generar oxigeno porque las instalaciones estan muy dañadas");
            error = true;
        }else if (energia < costeDeEnergia){
            System.out.println("No puedes generar oxigeno porque no tienes suficiente energía");
            error = true;
        }else {
            puedeCrearOxigeno = true; 
        }
        bouleanosReturneados.add(puedeCrearOxigeno);
        bouleanosReturneados.add(error);

        return bouleanosReturneados;
    }

    public static Arrays generarOxigeno(int energia, ArrayList<String> instalaciones,ArrayList<String> oxigeno) {
        ArrayList<Array> cosasQueNecesitoReturnear = new ArrayList<Array>();

        if(comprobacionInstalacionesYEnergia(3, 50, energia, instalaciones).get(1)==true){
            oxigeno.add("o");
            System.out.println("Has generado 1 de oxigeno");
        }else {
            comprobacionInstalacionesYEnergia(3, 50, energia, instalaciones);
        } 

        return cosasQueNecesitoReturnear;
    }

    public static String mejorarLaMoral() {
        Scanner miScanner = new Scanner(System.in);
        System.out.println("Selecciona 1 o 2");
        int input = miScanner.nextInt();

        if (input== 1){

        }else if (input == 2){

        }else {
            System.out.println("Input incorrecto");
        }
        
        return;
    }

    public static String repararInstalaciones() {
        return;
    }

    public static String recolectarEnergia() {
        return;
    }

    public static String comprarEnMercado() {
        return;
    }

    public static String inputIncorrecto() {
        return;
    }

    public static String gestionPrincipioRonda() {
        return;
    }

    public static void main(String[] args) {
        boolean error = false;
        Scanner miScanner = new Scanner(System.in);

        // Variables del menu principal y/o genericas a todo el codigo
        int input = 0;
        ArrayList<String> moral = new ArrayList<String>();
        ArrayList<String> oxigeno = new ArrayList<String>();
        ArrayList<String> instalaciones = new ArrayList<String>();

        int energia;
        int poblacion;

        ArrayList<String> inventario = new ArrayList<String>();

        while (input != 6) {
            System.out.println("Elige tu puta opcion anormal de los cojones");
            input = miScanner.nextInt();
            gestionPrincipioRonda();
            if (input == 1) {
                generarOxigeno(energia,instalaciones,oxigeno);
            } else if (input == 2) {
                mejorarLaMoral();
            } else if (input == 3) {
                repararInstalaciones();
            } else if (input == 4) {
                recolectarEnergia();
            } else if (input == 5) {
                comprarEnMercado();
            } else if (input == 6) {
                salirPrograma();
            } else {
                inputIncorrecto();
            }
        }
    }
}
