
import java.util.ArrayList;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class main {
    public static Almacen STEMAlmacenes = new Almacen();
    public static String generarCodigo(int i){
        String codigo = String.valueOf(i);
        return codigo;
    }
    public static void creacionInicial() {
        Almacen STEMAlmacenes = new Almacen();
        for (int i = 0; i < 1000; i++) {
            Producto nuevoProducto = new Producto(Faker.nombre(), generarCodigo(i), Faker.entero(0, 100),
                    Faker.precio(1, 2000));
            STEMAlmacenes.Productos.add(nuevoProducto);
        }
    }

    public static void menu(){
        System.out.println("===== GESTIÓN DE ALMACÉN =====\r\n" + //
                        "1. Mostrar todos los productos  \r\n" + //
                        "2. Buscar un producto por código  \r\n" + //
                        "3. Agregar stock a un producto  \r\n" + //
                        "4. Retirar stock de un producto  \r\n" + //
                        "5. Eliminar un producto  \r\n" + //
                        "6. Salir  \r\n" + //
                        "Seleccione una opción:");
    }
    public static void main(String[] args) {
        creacionInicial();
        Scanner stringScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        boolean salir = false;
        while (salir == false) {
            menu();
            int input = intScanner.nextInt();
            if (input == 1) {
                STEMAlmacenes.toString();
                // STEMAlmacenes.toString();
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
                        System.out.println(STEMAlmacenes.agregarStockAProducto(codigoProducto,cantidadAñadir));
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
                        System.out.println(STEMAlmacenes.retirarStockAProducto(codigoProducto,cantidadRetirar));
                    } else {
                        System.out.println("Introduce una cantidad mayor que 0");
                    }

                } else {
                    System.out.println("Producto no encontrado.");
                }
            } else if (input == 5) {
                // Eliminar un Producto is el stock es == 0
                System.out.println("Introduce el codigo del Producto");
                String codigoProducto = stringScanner.nextLine();
                Producto productoBuscado = STEMAlmacenes.buscarProductoPorCodigo(codigoProducto);
                int posicionProductoBuscado = STEMAlmacenes.buscarPosicionProductoPorCodigo(codigoProducto);
                if (productoBuscado != null) {
                    if (productoBuscado.getCantidad() == 0) {
                        System.out.println("El producto " + productoBuscado.getNombre() + " ha sido eliminado");
                        STEMAlmacenes.Productos.remove(posicionProductoBuscado);
                    } else {
                        System.out.println("No se puede eliminar un producto con stock");
                    }
                } else {
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
