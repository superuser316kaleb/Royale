package com.example.demo2.modelo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Tarjeta {
    private int id_usuario;
    private int id_metodo;
    private int cvv;
    private int terminacion;
    private String fecha_caducidad;

    public Tarjeta(){

    }

    public Tarjeta(int id_usuario, int id_metodo, int cvv, int terminacion, String fecha_caducidad) {
        this.id_usuario = id_usuario;
        this.id_metodo = id_metodo;
        this.cvv = cvv;
        this.terminacion = terminacion;
        this.fecha_caducidad = fecha_caducidad;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_metodo() {
        return id_metodo;
    }

    public void setId_metodo(int id_metodo) {
        this.id_metodo = id_metodo;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getTerminacion() {
        return terminacion;
    }

    public void setTerminacion(int terminacion) {
        this.terminacion = terminacion;
    }

    public String getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(String fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }
}
