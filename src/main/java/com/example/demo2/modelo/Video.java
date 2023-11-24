package com.example.demo2.modelo;

public class Video {
    private int id;
    private String titulo;
    private String descripcion;
    // Asumiendo que tienes otros atributos, defínelos aquí.

    // Constructor con parámetros
    public Video(int id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        // Inicializa aquí los otros atributos si existen.
    }

    // Getters y setters para todos los atributos.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Continúa con los otros getters y setters.
}
