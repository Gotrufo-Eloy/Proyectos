package Biblioteca;

public class MaterialBiblioteca {
    private String titulo;
    private String codigo;
    private String categoria;

    MaterialBiblioteca(String titulo, String codigo, String categoria) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
    
    
}
