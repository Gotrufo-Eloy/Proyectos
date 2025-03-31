package Biblioteca;

public class DVD extends MaterialBiblioteca implements Prestamo {
    private int duracionMinutos;
    private boolean prestado;

    public DVD(String titulo, String codigo, String categoria, int duracionMinutos) {
        super(titulo, codigo, categoria);
        this.duracionMinutos = duracionMinutos;
        this.prestado = false;
    }

    public void prestar() {
        if (!prestado) {
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

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public String getcodigo() {
        return super.getCodigo(); 
    }

    public void setcodigo(String codigo) {
        super.setCodigo(codigo); 
    }

    public String getCategoria() {
        return super.getCategoria(); 
    }

    public void setCategoria(String categoria) {
        super.setCategoria(categoria); 
    }

    public String getTitulo() {
        return super.getTitulo(); 
    }

    public void setTitulo(String titulo) {
        super.setTitulo(titulo); 
    }

    public String getCodigo() {
        return super.getCodigo(); 
    }

    public void setCodigo(String codigo) {
        super.setCodigo(codigo); 
    }

    @Override
    public String toString() {
        return "=== DVD ===\n" +
               "Título: " + getTitulo() + "\n" +
               "codigo: " + getcodigo() + "\n" +
               "Categoría: " + getCategoria() + "\n" +
               "Duración: " + duracionMinutos + " minutos\n" +
               "Estado: " + (prestado ? "Prestado" : "Disponible") + "\n";
    }
}
