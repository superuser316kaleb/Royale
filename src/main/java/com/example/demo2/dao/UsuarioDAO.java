package com.example.demo2.dao;

import com.example.demo2.modelo.Usuario;

import java.util.List;

public interface UsuarioDAO {
    Usuario obtenerPorId(int id);
    List<Usuario> obtenerTodos();
    void guardar(Usuario usuario);
    void actualizar(Usuario usuario);
    void eliminar(int id);
}