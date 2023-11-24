package com.example.demo2.dao;

import com.example.demo2.modelo.Canal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CanalDAOImpl {

    private static final String URL = "jdbc:mysql://tu_host:tu_puerto/tu_base_de_datos";
    private static final String USER = "tu_usuario";
    private static final String PASSWORD = "tu_contraseña";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

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
}
