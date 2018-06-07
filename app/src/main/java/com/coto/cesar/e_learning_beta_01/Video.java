package com.coto.cesar.e_learning_beta_01;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Objects;

public class Video {
    private long id;
    private String nameVideo;
    private String durationVideo;
    private String descriptonVideo;
    private String idVideo;
    private String urlVideo;
    private String urlImage;


    public Video() {
    }

    public Video(long id, String nameVideo, String durationVideo, String descriptonVideo,String idVideo, String urlVideo, String urlImage) {
        this.id = id;
        this.nameVideo = nameVideo;
        this.durationVideo = durationVideo;
        this.descriptonVideo = descriptonVideo;
        this.idVideo = idVideo;
        this.urlVideo = urlVideo;
        this.urlImage = urlImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameVideo() {
        return nameVideo;
    }

    public void setNameVideo(String nameVideo) {
        this.nameVideo = nameVideo;
    }

    public String getDurationVideo() {
        return durationVideo;
    }

    public void setDurationVideo(String durationVideo) {
        this.durationVideo = durationVideo;
    }

    public String getDescriptonVideo() {
        return descriptonVideo;
    }

    public void setDescriptonVideo(String descriptonVideo) {
        this.descriptonVideo = descriptonVideo;
    }

    public String getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(String idVideo) {
        this.idVideo = idVideo;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
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
        Video video = (Video) o;
        return id == video.id;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
