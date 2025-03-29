package Biblioteca;
public interface AccesoDigital {
    void iniciarSesion(String usuario);

    void cerrarSesion();

    boolean sesionActiva();
    
}
