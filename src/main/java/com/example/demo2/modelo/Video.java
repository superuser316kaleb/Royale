package com.example.demo2.modelo;

public class Video {
    private int duracion,anio_lanzamiento;
    private int id_video,id_categoria,id_subcategotia,id_tipo_video;
    private String titulo;
    private String descripcion,url,sinopsis,clasificacion,director,autor,actores;
    private double puntuacion;
    // Asumiendo que tienes otros atributos, defínelos aquí.

    // Constructor con parámetros

    public Video(int duracion, int anio_lanzamiento, int id_video, int id_categoria, int id_subcategotia, int id_tipo_video,
                 String titulo, String descripcion, String url, String sinopsis, String clasificacion, String director, String autor,
                 String actores, double puntuacion) {
        this.duracion = duracion;
        this.anio_lanzamiento = anio_lanzamiento;
        this.id_video = id_video;
        this.id_categoria = id_categoria;
        this.id_subcategotia = id_subcategotia;
        this.id_tipo_video = id_tipo_video;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
        this.sinopsis = sinopsis;
        this.clasificacion = clasificacion;
        this.director = director;
        this.autor = autor;
        this.actores = actores;
        this.puntuacion = puntuacion;
    }

    // Getters y setters para todos los atributos.

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getAnio_lanzamiento() {
        return anio_lanzamiento;
    }

    public void setAnio_lanzamiento(int anio_lanzamiento) {
        this.anio_lanzamiento = anio_lanzamiento;
    }

    public int getId_video() {
        return id_video;
    }

    public void setId_video(int id_video) {
        this.id_video = id_video;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_subcategotia() {
        return id_subcategotia;
    }

    public void setId_subcategotia(int id_subcategotia) {
        this.id_subcategotia = id_subcategotia;
    }

    public int getId_tipo_video() {
        return id_tipo_video;
    }

    public void setId_tipo_video(int id_tipo_video) {
        this.id_tipo_video = id_tipo_video;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    // Continúa con los otros getters y setters.
}
