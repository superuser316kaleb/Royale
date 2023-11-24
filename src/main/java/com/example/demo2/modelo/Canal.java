package com.example.demo2.modelo;

public class Canal {
    private int id;
    private String nombre;
    // Supongamos que hay otros atributos, también necesitarías agregarlos aquí.

    // Constructor sin argumentos si es necesario
    public Canal() {
    }

    // Constructor con argumentos si lo vas a utilizar
    public Canal(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    // Getters y setters para otros atributos si los hay
}
