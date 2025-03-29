package Biblioteca;
public class AudioLibro extends MaterialDigital implements Reservable {
    private String narrador;
    private int duracion; // en minutos

    public AudioLibro(String titulo, String codigo, String categoria, String url, String narrador, int duracion) {
        super(titulo, codigo, categoria, url);
        this.narrador = narrador;
        this.duracion = duracion;
    }

    public boolean sesionActiva(){
        return true;
    }

    public void reservar() {
        // Implementar lógica de reserva
    }

    public boolean estaReservado() {
        // Implementar lógica para verificar si está reservado
        return false; // Cambiar según la lógica implementada
    }

    public void cancelarReserva() {
        // Implementar lógica para cancelar reserva
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
    
}
