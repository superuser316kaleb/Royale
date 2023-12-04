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

    public boolean agregarAFavoritos(int idFavorito, int idUsuario, int idVideo) {
        String sql = "INSERT INTO favoritos (id_favorito, id_usuario, id_video) VALUES (?, ?, ?)";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idFavorito);
            statement.setInt(2, idUsuario);
            statement.setInt(3, idVideo);
            int filasInsertadas = statement.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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
    public boolean agregarAFavoritos(int idUsuario, int idVideo) {
        String sql = "INSERT INTO favoritos (id_usuario, id_video) VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idUsuario);
            statement.setInt(2, idVideo);
            int filasInsertadas = statement.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public int obtenerNuevoIdFavorito() {
        int nuevoId = 0; // Valor inicial por defecto o puedes tomar otro valor que asegure la unicidad

        // Lógica para obtener un nuevo ID único, por ejemplo, puedes hacer una consulta a la base de datos para obtener el próximo valor disponible
        String sql = "SELECT MAX(id_favorito) FROM favoritos"; // Consulta para obtener el máximo ID existente
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                nuevoId = resultSet.getInt(1) + 1; // Incrementar el máximo ID existente
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nuevoId;
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