package com.example.demo2.modelo;


public class CompraRenta {
    private int id_usuario;
    private int id_video;
    private String fecha;
    private String titulo;
    private String tipo;
    private double costo;

    // Constructor


    public CompraRenta(String fecha, String titulo, String tipo, double costo) {
        //this.id_usuario = idUsuario;
        //this.id_video = idVideo;
        this.fecha = fecha;
        this.titulo = titulo;
        this.tipo = tipo;
        this.costo = costo;
    }

    // Getters y setters para cada campo

    public int getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.id_usuario = idUsuario;
    }

    public int getIdVideo() {
        return id_video;
    }

    public void setIdVideo(int idVideo) {
        this.id_video = idVideo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    //toString

    @Override
    public String toString() {
        return "CompraRenta{" +
                "idUsuario=" + id_usuario +
                ", idVideo=" + id_video +
                ", fecha='" + fecha + '\'' +
                ", titulo='" + titulo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", costo=" + costo +
                '}';
    }
}