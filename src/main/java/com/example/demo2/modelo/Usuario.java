package com.example.demo2.modelo;




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

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(int metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId_subscription() {
        return id_subscription;
    }

    public void setId_subscription(int id_subscription) {
        this.id_subscription = id_subscription;
    }
// Constructor con todos los campos

}
