package com.example.demo2.modelo;


import lombok.Builder;
import lombok.Data;
@Data @Builder
public class Usuario {
    private int id_usuario;
    private String nombre;
    private String email;
    private String password;
    private int metodoPago;
    private int telefono;
    private String direccion;
    private int id_subscription;




    // Otros campos que pudieras tener

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con todos los campos

}
