package PT5Base;

import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class main {
    public static void creacionInicial() {
        Almacen STEMAlmacenes = new Almacen();
        for (int i = 0; i < 1000; i++) {
            Producto nuevoProducto = new Producto(Faker.nombre(), Faker.lorem(1), Faker.entero(0, 100),
                    Faker.precio(1, 2000));
        }
    }

    public static void main(String[] args) {
        creacionInicial();
        Scanner stringScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        boolean salir = false;
        while (salir == false) {
            int input = intScanner.nextInt();
            if (input == 1) {
                STEMAlmacenes.toString();
            } else if (input == 2) {
                System.out.println("Introduce el codigo del Producto");
                String codigoProducto = stringScanner.nextLine();
                Producto productoBuscado = STEMAlmacenes.buscarProductoPorCodigo(codigoProducto);
                if (productoBuscado != null) {
                    productoBuscado.toString();
                } else {
                    System.out.println("Producto no encontrado.");
                }
            } else if (input == 3) {
                System.out.println("Introduce el codigo del Producto");
                String codigoProducto = stringScanner.nextLine();
                Producto productoBuscado = STEMAlmacenes.buscarProductoPorCodigo(codigoProducto);
                if (productoBuscado != null) {
                    System.out.println("Introduce la cantidad a añadir");
                    int cantidadAñadir = intScanner.nextInt();
                    if (cantidadAñadir > 0) {
                        System.out.println(STEMAlmacenes.agregarStockAProducto(cantidadAñadir));
                    } else {
                        System.out.println("Introduce una cantidad mayor que 0");
                    }

                } else {
                    System.out.println("Producto no encontrado.");
                }
            } else if (input == 4) {
                System.out.println("Introduce el codigo del Producto");
                String codigoProducto = stringScanner.nextLine();
                Producto productoBuscado = STEMAlmacenes.buscarProductoPorCodigo(codigoProducto);
                if (productoBuscado != null) {
                    System.out.println("Introduce la cantidad a retirar");
                    int cantidadRetirar = intScanner.nextInt();
                    if (cantidadRetirar > 0) {
                        System.out.println(STEMAlmacenes.retirarStockAProducto(cantidadRetirar));
                    } else {
                        System.out.println("Introduce una cantidad mayor que 0");
                    }

                } else {
                    System.out.println("Producto no encontrado.");
                }
            } else if (input == 5) {
                System.out.println("Introduce el codigo del Producto");
                String codigoProducto = stringScanner.nextLine();
                Producto productoBuscado = STEMAlmacenes.buscarProductoPorCodigo(codigoProducto);
                if (productoBuscado != null) {
                    
                } else if () {
                    System.out.println("Producto no encontrado.");
                }else {
                    System.out.println("Producto no encontrado.");
                }
            } else if (input == 6) {
                System.out.println("Saliendo del programa");
                salir = true;
            } else {
                System.out.println("Input incorrecto");
            }

        }
    }
}
