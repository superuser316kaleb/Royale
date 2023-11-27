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
    public Usuario(int id_usuario, String usuario, String nombre, String apellido, String domicilio, String telefono, int id_tipo_suscripcion, int tipo_usuario, String contrasena, String email) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.id_tipo_suscripcion = id_tipo_suscripcion;
        this.tipo_usuario = tipo_usuario;
        this.contrasena = contrasena;
        this.email = email;
    }

    //getters y setters

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_tipo_suscripcion() {
        return id_tipo_suscripcion;
    }

    public void setId_tipo_suscripcion(int id_tipo_suscripcion) {
        this.id_tipo_suscripcion = id_tipo_suscripcion;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}