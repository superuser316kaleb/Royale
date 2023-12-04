package com.example.demo2.dao;

import com.example.demo2.MySQLConnection;
import com.example.demo2.modelo.Favoritos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


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

    public List<Map<Integer,String>> obtenerTodos() {

        List<Map<Integer,String>> lista = new ArrayList<Map<Integer,String>>();
        String sql = "select f.id_favorito,u.nombre,v.titulo from usuarios u\n" +
                "join favoritos f on u.id_usuario = f.id_usuario\n" +
                "join videos v on v.id_video = f.id_video;";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Map<Integer,String> map= new HashMap<>();
                map.put(1,rs.getString("id_favorito"));
                map.put(2,rs.getString("nombre"));
                map.put(3,rs.getString("titulo"));

                lista.add(map);
                //canales.add(canal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
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