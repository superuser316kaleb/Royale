package com.example.demo2.dao;

import com.example.demo2.MySQLConnection;
import com.example.demo2.modelo.Favoritos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class FavoritosDAOImpl extends MySQLConnection implements Dao<Favoritos> {

    Connection conn = getConnection();
    private int idUsuario;

    public void agregarFavorito(Favoritos favorito) {
        String query = "INSERT INTO favoritos (id_usuario, id_video) VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, favorito.getId_usuario());
            statement.setInt(2, favorito.getId_video());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Favoritos> obtenerFavoritosPorUsuario() {
        List<Favoritos> listaFavoritos = new ArrayList<>();
        String query = "SELECT id_favorito, id_usuario, id_video FROM favoritos WHERE id_usuario = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, idUsuario);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Favoritos favorito = new Favoritos();
                favorito.setId_favorito(resultSet.getInt("id_favorito"));
                favorito.setId_usuario(resultSet.getInt("id_usuario"));
                favorito.setId_video(resultSet.getInt("id_video"));
                listaFavoritos.add(favorito);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaFavoritos;
    }

    @Override
    public Optional<Favoritos> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Favoritos> findAll() {
        return null;
    }

    @Override
    public boolean save(Favoritos record) {
        return false;
    }

    @Override
    public boolean update(Favoritos record) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

}