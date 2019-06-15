package vite.kike.dbtest;

public class Nota {
    private long id;
    private String titulo;
    private String contenido;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Nota(long id, String titulo, String contenido) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public Nota(String titulo, String contenido) {
        this.id = -1;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public Nota(String titulo) {
        this.id = -1;
        this.titulo = titulo;
        this.contenido = "";
    }

    public Nota() {
        this.id = -1;
        this.titulo = "";
        this.contenido = "";
    }

}
