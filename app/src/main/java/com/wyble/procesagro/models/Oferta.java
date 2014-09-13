package com.wyble.procesagro.models;

/**
 * Created by david on 9/11/14.
 */
public class Oferta {

    private int id;

    private String usuario;

    private String titulo;

    private String descripcion;

    private String url_audio;

    private String url;

    public Oferta(int id, String usuario, String titulo, String descripcion, String url_audio, String url) {
        this.id = id;
        this.usuario = usuario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url_audio = url_audio;
        this.url = url;
    }

    @Override
    public String toString() {
        return titulo;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrl_audio() {
        return url_audio;
    }

    public String getUrl() {
        return url;
    }
}
