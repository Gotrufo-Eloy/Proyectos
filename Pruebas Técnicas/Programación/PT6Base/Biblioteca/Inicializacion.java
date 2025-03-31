package Biblioteca;

import java.util.ArrayList;

public class Inicializacion {
    public static ArrayList<MaterialBiblioteca> crearBiblioteca(){
        ArrayList<MaterialBiblioteca> materiales = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            materiales.add(crearLibroFisico());
            materiales.add(crearDVD());
            materiales.add(crearRevistaDigital());
            materiales.add(crearAudioLibro());
        }
        return materiales;
    }
    public static LibroFisico crearLibroFisico() {
        return new LibroFisico(Faker.titulo(), Faker.DNI(), Faker.categoria(), Faker.entero(0, 2025));
    }
    public static DVD crearDVD() {
        return new DVD(Faker.titulo(), Faker.DNI(), Faker.categoria(), Faker.entero(0, 300));
    }
    public static RevistaDigital crearRevistaDigital() {
        return new RevistaDigital(Faker.titulo(), Faker.DNI(), Faker.categoria(),Faker.url(),Faker.entero(0, 25) ,Faker.nombreCompleto());
    }
    public static AudioLibro crearAudioLibro() {
        return new AudioLibro(Faker.titulo(), Faker.DNI(), Faker.categoria(),Faker.url(),Faker.nombreCompleto(),Faker.entero(0, 300));
    }
}
