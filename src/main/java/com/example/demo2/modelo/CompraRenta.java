package com.example.demo2.modelo;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
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