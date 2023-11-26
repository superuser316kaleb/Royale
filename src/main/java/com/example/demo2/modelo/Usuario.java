package com.example.demo2.modelo;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Usuario {
    private int id_usuario;
    private String usuario;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String telefono;
    private int id_tipo_suscripcion;
    private int tipo_usuario;
    private String contrasena;
    private String email;


    // Otros campos que pudieras tener

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con todos los campos

    //getters y setters

}