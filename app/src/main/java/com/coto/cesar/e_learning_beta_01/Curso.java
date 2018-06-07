package com.coto.cesar.e_learning_beta_01;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Objects;

public class Curso {
    private int id;
    private String nombre;
    private String numeroVideos;
    private String nivel;
    private String estado;
    private String urlPlaylist;
    private String urlImage;

    public Curso(int id, String nombre, String numeroVideos, String nivel, String estado, String urlPlaylist, String urlImage) {
        this.id = id;
        this.nombre = nombre;
        this.numeroVideos = numeroVideos;
        this.nivel = nivel;
        this.estado = estado;
        this.urlPlaylist = urlPlaylist;
        this.urlImage = urlImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroVideos() {
        return numeroVideos;
    }

    public void setNumeroVideos(String numeroVideos) {
        this.numeroVideos = numeroVideos;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUrlPlaylist() {
        return urlPlaylist;
    }

    public void setUrlPlaylist(String urlPlaylist) {
        this.urlPlaylist = urlPlaylist;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return id == curso.id;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
