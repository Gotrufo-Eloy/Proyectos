package Relacion2;

import java.util.ArrayList;
import java.util.Scanner;

class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String sinopsis;
    private boolean disponible;

    public Libro(int id, String titulo, String autor, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.sinopsis = sinopsis;
        this.disponible = true;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void prestarLibro() {
        if (this.disponible = false) {
            System.out.println("El libro no esta disponible");
        } else {
            this.disponible = false;
            System.out.println("El libro ha sido prestado correctamente");
        }
    }

    public void devolverLibro() {
        if (this.disponible = true) {
            System.out.println("El libro no esta prestado");
        } else {
            this.disponible = true;
            System.out.println("El libro ha sido devuelto correctamente");
        }
    }

    public String toString() {
        return "Id:" + this.id + " - Titulo:" + this.titulo + " - Autor:" + this.autor + " - Disponible:"
                + this.disponible + " - Sinopsis" + this.sinopsis;
    }

}

class Biblioteca {
    private ArrayList<Libro> libros;
    private String nombreBiblioteca;

    public Biblioteca(String nombreBiblioteca) {
        this.libros = new ArrayList<Libro>();
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public ArrayList<Libro> getLibros(){
        return this.libros;
    }

    public void agregarLibro(Libro nuevoLibro) {
        this.libros.add(nuevoLibro);
    }

    public void prestarLibro(String tituloLibro) {
        boolean encontrado = false;
        for (int i = 0; i < libros.size() && encontrado == false; i++) {
            Libro libroActual = libros.get(i);
            System.out.println("biblioteca.prestarlibro");
            if (tituloLibro.equals(libroActual.getTitulo())) {
                encontrado = true;
                libroActual.prestarLibro();
                System.out.println("if entrado correctamente");
            }
        }
        if (encontrado == false) {
            System.out.println("El libro no se ha encontrado");
        }
    }

    public void devolverLibro(String tituloLibro) {
        boolean encontrado = false;
        for (int i = 0; i < libros.size() && encontrado == false; i++) {
            Libro libroActual = libros.get(i);
            if (tituloLibro.equals(libroActual.getTitulo())) {
                encontrado = true;
                libroActual.devolverLibro();
            }
        }
        if (encontrado == false) {
            System.out.println("El libro no se ha encontrado");
        }
    }

    public String toString() {
        String line = "Lirbos en la biblioteca " + this.nombreBiblioteca + ": \n";
        for (Libro libro : libros) {
            line += libro + "\n";
        }
        return line;
    }
}

public class Ejercicio2 {
    public static final int numeroLibros = 2;

    public static void main(String[] args) {
        Scanner scannerInts = new Scanner(System.in);
        Scanner scannerStrings = new Scanner(System.in);

        Biblioteca Filo = new Biblioteca("Filosofía y Letras");
        for (int i = 0; i < numeroLibros; i++) {
            Libro libroNuevo = new Libro(i, Faker.lorem(2), Faker.nombreCompleto(), Faker.loremLargo());
            Filo.agregarLibro(libroNuevo);
        }


        int input = 0;
        while (input != 4) {
            System.out.println(Filo);
            System.out.println("Elige:\n1 Agregar libros\n2 Prestar un libro\n3 Devolver un libro\n4 SALIR");
            input = scannerInts.nextInt();
            if (input == 1) {
                System.out.println("Introduce el Titulo");
                String tituloLibroNuevo = scannerStrings.nextLine();
                System.out.println("Introduce el autor");
                String autorLibroNuevo = scannerStrings.nextLine();
                System.out.println("Introduce la descripcion ");
                String descripcionLibroNuevo = scannerStrings.nextLine();
                Libro libroNuevo = new Libro((Filo.getLibros().size()), tituloLibroNuevo, autorLibroNuevo, descripcionLibroNuevo);
                Filo.agregarLibro(libroNuevo);
            } else if (input == 2) {
                System.out.println("Introduce el Titulo del libro");
                String tituloLibro = scannerStrings.nextLine();
                Filo.prestarLibro(tituloLibro);
            } else if (input == 3) {
                System.out.println("Introduce el Titulo del libro");
                String tituloLibro = scannerStrings.nextLine();
                Filo.devolverLibro(tituloLibro);
            } else if (input == 4) {
                System.out.println("bye");
            } else {
                System.out.println("Input desconocido porfavor introduce el input correcto ");
            }
        }

    }
}
