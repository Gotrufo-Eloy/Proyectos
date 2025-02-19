package Relacion2;

import java.util.ArrayList;

class Estudiante {
    private String nombre;
    private int edad;
    private int numeroMatricula;

    public Estudiante(String nombre, int edad, int numeroMatricula) {
        this.nombre = nombre;
        this.edad = edad;
        this.numeroMatricula = numeroMatricula;
    }

    public int getEdad() {
        return this.edad;
    }

    public int getNumeroDeMatricula() {
        return this.numeroMatricula;
    }

    public String toString() {
        return this.numeroMatricula + " - " + this.nombre + " - " + this.edad;
    }

}

class Universidad {
    private ArrayList<Estudiante> estudiantes;

    public Universidad() {
        this.estudiantes = new ArrayList<Estudiante>();
    }

    public void añadirEstudiante(Estudiante nuevoEstudiante) {
        this.estudiantes.add(nuevoEstudiante);
    }

    public String toString() {
        String line = "Estudiantes de la universidad:\n";
        for (Estudiante estudiante : estudiantes) {
            line += estudiante + "\n";
        }
        return line;
    }

    public Estudiante buscarEstudiante(int numeroMatricula) {
        Estudiante buscado = null;
        for (int i = 0; i < estudiantes.size() && buscado == null; i++) {
            Estudiante estudianteActual = estudiantes.get(i);
            if (estudianteActual.getNumeroDeMatricula() == numeroMatricula) {
                buscado = estudianteActual;
            }
        }
        return buscado;
    }

}

public class Ejercicio1 {
    public static final int numeroEstudiantes = 100;
    public static void main(String[] args) {
        Universidad UCO = new Universidad();
        for (int i = 0; i < numeroEstudiantes; i++) {
            Estudiante nuevoEstudiante= new Estudiante(Faker.nombre(), Faker.edad(), i);
            UCO.añadirEstudiante(nuevoEstudiante);
        }
        System.out.println(UCO);
    }
}
