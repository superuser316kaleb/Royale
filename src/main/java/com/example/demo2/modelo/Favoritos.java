package com.example.demo2.modelo;

public class Favoritos {
    private int id_favorito;
    private int id_usuario;

    private int id_video;

    public Favoritos(int id_favorito, int id_usuario, int id_video) {
        this.id_favorito = id_favorito;
        this.id_usuario = id_usuario;
        this.id_video = id_video;
    }

    public Favoritos( ) {

    }

    public int getId_favorito() {
        return id_favorito;
    }

    public void setId_favorito(int id_favorito) {
        this.id_favorito = id_favorito;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_video() {
        return id_video;
    }

    public void setId_video(int id_video) {
        this.id_video = id_video;
    }

    @Override
    public String toString() {
        return "Favoritos{" +
                "id_favorito=" + id_favorito +
                ", id_usuario=" + id_usuario +
                ", id_video=" + id_video +
                '}';
    }
}
