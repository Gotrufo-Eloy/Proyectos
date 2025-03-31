package Biblioteca;

public class RevistaDigital extends MaterialDigital {
    private int edicion;
    private String publicador;

    public RevistaDigital(String titulo, String codigo, String categoria, String url, int edicion, String publicador) {
        super(titulo, codigo, categoria, url);
        this.edicion = edicion;
        this.publicador = publicador;
    }

    public boolean sesionActiva() {
        return getSesionActiva();
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getPublicador() {
        return publicador;
    }

    public void setPublicador(String publicador) {
        this.publicador = publicador;
    }

    @Override
    public String toString() {
        return "=== Revista Digital ===\n" +
                "Título: " + getTitulo() + "\n" +
                "Código: " + getCodigo() + "\n" +
                "Categoría: " + getCategoria() + "\n" +
                "Edición: " + edicion + "\n" +
                "Publicador: " + publicador + "\n" +
                "URL: " + getUrl() + "\n";
    }
}
