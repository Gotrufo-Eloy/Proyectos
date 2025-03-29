package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner intScanner = new Scanner(System.in);
    public static Scanner stringScanner = new Scanner(System.in);

    public static ArrayList<MaterialBiblioteca> materiales = new ArrayList<>();
    // public static ArrayList<Prestamo> prestamos = new ArrayList<>();
    // public static ArrayList<Reservable> reservas = new ArrayList<>();

    public static void menu() {
        System.out.println("===== SISTEMA DE GESTIÓN DE BIBLIOTECA =====\r\n" + //
                "1. Registrar nuevo material\r\n" + //
                "2. Listar todos los materiales\r\n" + //
                "3. Prestar un material\r\n" + //
                "4. Devolver un material\r\n" + //
                "5. Reservar / Cancelar reserva\r\n" + //
                "6. Iniciar / Cerrar sesión digital\r\n" + //
                "7. Salir\r\n" + //
                "Seleccione una opción:\r");
    }

    public static String[] crearMaterialBiblioteca(String tipoMaterial) {
        System.out.println("Ingrese el título del " + tipoMaterial + ": ");
        String titulo = stringScanner.nextLine();
        String codigo = null;
        while (!codigoExiste(codigo)) {
            System.out.println("Ingrese el codigo del " + tipoMaterial + ": ");
            codigo = stringScanner.nextLine();
        }

        System.out.println("Ingrese la categoría del " + tipoMaterial + ": ");
        String categoria = stringScanner.nextLine();
        String[] material = new String[3];
        material[0] = titulo;
        material[1] = codigo;
        material[2] = categoria;
        return material;
    }

    public static boolean codigoExiste(String codigo) {
        boolean existe = false;
        for (MaterialBiblioteca material : materiales) {
            if (material.getCodigo().equalsIgnoreCase(codigo)&&codigo != null) {
                System.out.println("El código ya existe. Por favor, ingrese otro.");
                existe = true;
            }
        }
        return existe;
    }

    public static void crearLibroFisico() {
        String[] base = crearMaterialBiblioteca("Libro Fisico");
        String titulo = base[0];
        String codigo = base[1];
        String categoria = base[2];
        System.out.println("Ingrese el número de páginas: ");
        int numeroPaginas = intScanner.nextInt();
        LibroFisico libro = new LibroFisico(titulo, codigo, categoria, numeroPaginas);
        materiales.add(libro);
    }

    public static void crearDVD() {
        String[] base = crearMaterialBiblioteca("DVD");
        String titulo = base[0];
        String codigo = base[1];
        String categoria = base[2];
        System.out.println("Ingrese la duración en minutos: ");
        int duracionMinutos = intScanner.nextInt();
        DVD dvd = new DVD(titulo, codigo, categoria, duracionMinutos);
        materiales.add(dvd);
    }

    public static void crearRevistaDigital() {
        String[] base = crearMaterialBiblioteca("Revista Digital");
        String titulo = base[0];
        String codigo = base[1];
        String categoria = base[2];
        System.out.println("Ingrese la URL: ");
        String url = stringScanner.nextLine();
        System.out.println("Ingrese la edición: ");
        int edicion = intScanner.nextInt();
        System.out.println("Ingrese el publicador: ");
        String publicador = stringScanner.nextLine();
        RevistaDigital revista = new RevistaDigital(titulo, codigo, categoria, url, edicion, publicador);
        materiales.add(revista);
    }

    public static void crearAudioLibro() {
        String[] base = crearMaterialBiblioteca("Audio Libro");
        String titulo = base[0];
        String codigo = base[1];
        String categoria = base[2];
        System.out.println("Ingrese la URL: ");
        String url = stringScanner.nextLine();
        System.out.println("Ingrese el narrador: ");
        String narrador = stringScanner.nextLine();
        System.out.println("Ingrese la duración en minutos: ");
        int duracion = intScanner.nextInt();
        AudioLibro audioLibro = new AudioLibro(titulo, codigo, categoria, url, narrador, duracion);
        materiales.add(audioLibro);
    }

    public static void listaMateriales() {
        System.out.println("Lista de materiales:");
        for (MaterialBiblioteca material : materiales) {
            System.out.println(material.toString());
        }
    }

    public static void submenuReservarCancelar() {
        System.out.println("1. Reservar\r\n" + //
                "2. Cancelar reserva\r\n" + //
                "Seleccione una opción:\r");

    }

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            menu();
            int opcion = intScanner.nextInt();
            if (opcion == 1) {
                // Registrar nuevo material
                System.out.println("Ingrese el tipo de material (LibroFisico, DVD, RevistaDigital, AudioLibro): ");
                String tipoMaterial = stringScanner.nextLine();
                if (tipoMaterial.equalsIgnoreCase("LibroFisico")) {
                    crearLibroFisico();
                } else if (tipoMaterial.equalsIgnoreCase("DVD")) {
                    crearDVD();
                } else if (tipoMaterial.equalsIgnoreCase("RevistaDigital")) {
                    crearRevistaDigital();
                } else if (tipoMaterial.equalsIgnoreCase("AudioLibro")) {
                    crearAudioLibro();
                } else {
                    System.out.println("Tipo de material no válido.");
                }
            } else if (opcion == 2) {
                // Listar todos los materiales
                listaMateriales();
            } else if (opcion == 3) {
                // Prestar un material
                listaMateriales();
                System.out.println("Ingrese el codigo del material a prestar: ");
                String codigo = stringScanner.nextLine();
                MaterialBiblioteca materialBuscado = null;
                for (int i = 0; i < materiales.size() && materialBuscado == null; i++) {
                    if (materiales.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                        materialBuscado = materiales.get(i);
                    }
                }
                if (materialBuscado instanceof Prestamo) {
                    ((Prestamo) materialBuscado).prestar();

                } else {
                    System.out.println("El material no se puede prestar.");
                }
            } else if (opcion == 4) {
                // Devolver un material
                listaMateriales();
                System.out.println("Ingrese el codigo del material a devolver: ");
                String codigo = stringScanner.nextLine();
                MaterialBiblioteca materialBuscado = null;
                for (int i = 0; i < materiales.size() && materialBuscado == null; i++) {
                    if (materiales.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                        materialBuscado = materiales.get(i);
                    }
                }
                if (materialBuscado instanceof Prestamo) {
                    if (!((Prestamo) materialBuscado).estaPrestado()) {
                        System.out.println("El material no está prestado.");
                    } else {
                        ((Prestamo) materialBuscado).devolver();
                        System.out.println("El material ha sido devuelto.");
                    }
                } else {
                    System.out.println("El material no se puede devolver.");
                }
            } else if (opcion == 5) {
                // Reservar / Cancelar reserva
                submenuReservarCancelar();
                int subOpcion = intScanner.nextInt();
                if (subOpcion == 1) {
                    listaMateriales();
                    System.out.println("Ingrese el codigo del material a reservar: ");
                    String codigo = stringScanner.nextLine();
                    MaterialBiblioteca materialBuscado = null;
                    for (int i = 0; i < materiales.size() && materialBuscado == null; i++) {
                        if (materiales.get(i).getTitulo().equalsIgnoreCase(codigo)) {
                            materialBuscado = materiales.get(i);
                        }
                    }
                    if (materialBuscado instanceof Reservable) {
                        if (materialBuscado instanceof Prestamo) {
                            if (((Prestamo) materialBuscado).estaPrestado()
                                    && ((Reservable) materialBuscado).estaReservado()) {
                                System.out.println("El material ya está prestado o reservado.");
                            } else {
                                ((Reservable) materialBuscado).reservar();
                                System.out.println("El material ha sido reservado.");
                            }
                        } else {
                            if (((Reservable) materialBuscado).estaReservado()) {
                                System.out.println("El material ya está reservado.");
                            } else {
                                ((Reservable) materialBuscado).reservar();
                                System.out.println("El material ha sido reservado.");
                            }
                        }
                    } else {
                        System.out.println("El material no es reservable.");
                    }
                } else if (subOpcion == 2) {
                    listaMateriales();
                    System.out.println("Ingrese el codigo del material a cancelar reserva: ");
                    String codigo = stringScanner.nextLine();
                    MaterialBiblioteca materialBuscado = null;
                    for (int i = 0; i < materiales.size() && materialBuscado == null; i++) {
                        if (materiales.get(i).getTitulo().equalsIgnoreCase(codigo)) {
                            materialBuscado = materiales.get(i);
                        }
                    }
                    if (materialBuscado instanceof Prestamo) {
                        if (materialBuscado instanceof Reservable) {
                            if (((Prestamo) materialBuscado).estaPrestado()
                                    && ((Reservable) materialBuscado).estaReservado()) {
                                System.out.println("El material ya está prestado o reservado.");
                            } else {
                                ((Prestamo) materialBuscado).prestar();
                                System.out.println("El material ha sido reservado.");
                            }
                        } else {
                            if (((Prestamo) materialBuscado).estaPrestado()) {
                                System.out.println("El material ya está reservado.");
                            } else {
                                ((Prestamo) materialBuscado).prestar();
                                System.out.println("El material ha sido reservado.");
                            }
                        }
                    } else {
                        System.out.println("El material no es reservable.");
                    }

                }
            } else if (opcion == 6) {
                // Iniciar / Cerrar sesión digital
                listaMateriales();
                System.out.println("Ingrese el codigo del material a iniciar/cerrar sesión: ");
                String codigo = stringScanner.nextLine();
                MaterialBiblioteca materialBuscado = null;
                for (int i = 0; i < materiales.size() && materialBuscado == null; i++) {
                    if (materiales.get(i).getTitulo().equalsIgnoreCase(codigo)) {
                        materialBuscado = materiales.get(i);
                    }
                }
                if (materialBuscado instanceof MaterialDigital) {
                    if (((MaterialDigital) materialBuscado).sesionActiva()) {
                        ((MaterialDigital) materialBuscado).cerrarSesion();
                        System.out.println("Sesión cerrada.");
                    } else {
                        System.out.println("Ingrese el nombre de usuario: ");
                        String usuario = stringScanner.nextLine();
                        ((MaterialDigital) materialBuscado).iniciarSesion(usuario);
                        System.out.println("Sesión iniciada:");
                        System.out.println(((MaterialDigital) materialBuscado).getUsuario());
                    }
                } else {
                    System.out.println("El material no es digital.");
                }
            } else if (opcion == 7) {
                salir = true;
                System.out.println("Saliendo del sistema...");
            } else {
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }

        }
    }
}
