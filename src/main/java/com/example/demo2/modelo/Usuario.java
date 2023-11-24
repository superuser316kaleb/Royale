package com.example.demo2.modelo;



public class Usuario {
    private int id;
    private String nombre;
    private String email;
    // Otros campos que pudieras tener

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con todos los campos
    public Usuario(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        // Inicializar otros campos si existen
    }

    // Getters y setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Otros getters y setters para campos adicionales
}
