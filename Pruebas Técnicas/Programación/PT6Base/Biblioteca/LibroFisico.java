package Biblioteca;

public class LibroFisico extends MaterialBiblioteca implements Prestamo, Reservable {
    private int anioPublicacion;
    private boolean prestado;
    private boolean reservado;

    public LibroFisico(String titulo, String codigo, String categoria, int anioPublicacion) {
        super(titulo, codigo, categoria);
        this.anioPublicacion = anioPublicacion;
        this.prestado = false;
        this.reservado = false;
    }

    public void prestar() {
        if (!prestado && !reservado) {
            prestado = true;
        }
    }

    public void devolver() {
        if (prestado) {
            prestado = false;
        }
    }

    public boolean estaPrestado() {
        return prestado;
    }

    public void reservar() {
        if (!prestado && !reservado) {
            reservado = true;
        }
    }

    public void cancelarReserva() {
        reservado = false;
    }

    public boolean estaReservado() {
        return reservado;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    @Override
    public String toString() {
        return "=== Libro Físico ===\n" +
                "Título: " + getTitulo() + "\n" +
                "Código: " + getCodigo() + "\n" +
                "Categoría: " + getCategoria() + "\n" +
                "Año de Publicación: " + anioPublicacion + "\n" +
                "Estado: " + (prestado ? "Prestado" : "Disponible") + "\n" +
                "Reservado: " + (reservado ? "Sí" : "No") + "\n";
    }

}
