package com.example.demo2.dao;

import com.example.demo2.MySQLConnection;
import com.example.demo2.modelo.Canal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CanalDAOImpl extends MySQLConnection implements Dao<Canal>{

    Connection conn = getConnection();

    public Canal obtenerPorId(int id) {
        String sql = "SELECT * FROM canales WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Canal canal = new Canal();
                canal.setId(rs.getInt("id"));
                canal.setNombre(rs.getString("nombre"));
                // Suponiendo que hay otros campos, los inicializas aquí.
                return canal;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Canal> obtenerTodos() {
        List<Canal> canales = new ArrayList<>();
        String sql = "SELECT * FROM canales";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Canal canal = new Canal();
                canal.setId(rs.getInt("id"));
                canal.setNombre(rs.getString("nombre"));
                // Suponiendo que hay otros campos, los inicializas aquí.
                canales.add(canal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return canales;
    }

    public void guardar(Canal canal) {
        String sql = "INSERT INTO canales (nombre) VALUES (?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, canal.getNombre());
            // Suponiendo que hay otros campos, los bindeas aquí.
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar(Canal canal) {
        String sql = "UPDATE canales SET nombre = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, canal.getNombre());
            // Suponiendo que hay otros campos, los actualizas aquí.
            pstmt.setInt(2, canal.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM canales WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Canal> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Canal> findAll() {
        return null;
    }

    @Override
    public boolean save(Canal record) {
        return false;
    }

    @Override
    public boolean update(Canal record) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
