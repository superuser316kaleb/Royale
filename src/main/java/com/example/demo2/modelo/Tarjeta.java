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

}
