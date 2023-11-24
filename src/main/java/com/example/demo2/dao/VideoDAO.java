package com.example.demo2.dao;

import com.example.demo2.modelo.Video;
import java.util.List;

public interface VideoDAO {
    Video obtenerPorId(int id);
    List<Video> obtenerTodos();
    void guardar(Video video);
    void actualizar(Video video);
    void eliminar(int id);
}
