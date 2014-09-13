package com.wyble.procesagro.models;

/**
 * Created by david on 9/11/14.
 */
public class PasoOferta {

    private int id;

    private String titulo;

    private String descripcion;

    private String url;

    private Oferta oferta;

    public PasoOferta(int id, String titulo, String descripcion, String url, Oferta oferta) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
        this.oferta = oferta;
    }

    @Override
    public String toString() {
        return titulo;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrl() {
        return url;
    }

    public Oferta getOferta() {
        return oferta;
    }
}
