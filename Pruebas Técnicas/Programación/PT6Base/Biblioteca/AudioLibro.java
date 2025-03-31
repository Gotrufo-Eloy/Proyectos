package Biblioteca;

public class AudioLibro extends MaterialDigital implements Reservable {
    private String narrador;
    private int duracion; // en minutos
    private boolean reservado;

    public AudioLibro(String titulo, String codigo, String categoria, String url, String narrador, int duracion) {
        super(titulo, codigo, categoria, url);
        this.narrador = narrador;
        this.duracion = duracion;
        this.reservado = false;
    }

    public boolean sesionActiva() {
        return getSesionActiva();
    }

    public void reservar() {
        if (!reservado) {
            this.reservado = true;
        }
    }

    public boolean estaReservado() {
        return reservado;
    }

    public void cancelarReserva() {
        if (reservado) {
            reservado = false;
        }
    }

    public String getNarrador() {
        return narrador;
    }

    public void setNarrador(String narrador) {
        this.narrador = narrador;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "=== Audio Libro ===\n" +
                "Título: " + getTitulo() + "\n" +
                "Código: " + getCodigo() + "\n" +
                "Categoría: " + getCategoria() + "\n" +
                "Narrador: " + narrador + "\n" +
                "Duración: " + duracion + " minutos\n" +
                "URL: " + getUrl() + "\n";
    }

}
