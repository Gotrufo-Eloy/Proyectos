package Biblioteca;

public class LibroFisico extends MaterialBiblioteca implements Prestamo, Reservable {
    private String codigo;
    private int anioPublicacion;
    private boolean prestado;
    private boolean reservado;

    public LibroFisico(String titulo, String codigo, String categoria, int anioPublicacion) {
        super(titulo, codigo, categoria);
        this.codigo = codigo;
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
        
    }

    public boolean estaReservado() {
        return reservado;
    }

    public String getcodigo() {
        return codigo;
    }

    public void setcodigo(String codigo) {
        this.codigo = codigo;
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

    public String toString() {
        return "LibroFisico{" +
                "titulo='" + getTitulo() + '\'' +
                ", codigo='" + codigo + '\'' +
                ", categoria='" + getCategoria() + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", prestado=" + prestado +
                ", reservado=" + reservado +
                '}';
    }

}
