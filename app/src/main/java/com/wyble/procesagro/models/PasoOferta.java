package com.wyble.procesagro.models;

import java.io.Serializable;

/**
 * Created by david on 9/11/14.
 */
public class PasoOferta implements Serializable {

    private int id;

    private String titulo;

    private String descripcion;

    private String url;

    private Boolean is_checked;

    public PasoOferta(int id, String titulo, String descripcion, String url) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
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

    public Boolean getIsChecked() {
        return is_checked;
    }

    public void setIsChecked(Boolean is_checked) {
        this.is_checked = is_checked;
    }
}
