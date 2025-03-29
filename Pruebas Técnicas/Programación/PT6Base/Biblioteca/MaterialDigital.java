package Biblioteca;
abstract class MaterialDigital extends MaterialBiblioteca implements AccesoDigital {
    private String usuario;
    private String url;
    private boolean sesionActiva;

    public MaterialDigital(String titulo, String codigo, String categoria, String url) {
        super(titulo, codigo, categoria);
        this.url = url;
        this.sesionActiva = false;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getSesionActiva() {
        return sesionActiva;
    }
    
    public void iniciarSesion(String usuario) {
        this.usuario = usuario;
        this.sesionActiva = true;
    }

    public void cerrarSesion() {
        this.usuario = null;
        this.sesionActiva = false;
    }

}
