package com.coto.cesar.e_learning_beta_01;

import java.util.Objects;

public class CVideo {
    private long id;
    private String nombre;
    private String duracion;
    private String IdVideo;
    private String urlVideo;

    public CVideo(long id, String nombre, String duracion, String idVideo, String urlVideo) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        IdVideo = idVideo;
        this.urlVideo = urlVideo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getIdVideo() {
        return IdVideo;
    }

    public void setIdVideo(String idVideo) {
        IdVideo = idVideo;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CVideo cVideo = (CVideo) o;
        return id == cVideo.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
