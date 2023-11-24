package com.example.demo2.dao;

import com.example.demo2.modelo.Video;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideoDAOImpl implements VideoDAO {

    private static final String URL = "jdbc:mysql://tu_host:tu_puerto/tu_base_de_datos";
    private static final String USER = "tu_usuario";
    private static final String PASSWORD = "tu_contraseña";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public Video obtenerPorId(int id) {
        String sql = "SELECT * FROM videos WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Video(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descripcion")
                        // Continúa con los demás atributos...
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Video> obtenerTodos() {
        List<Video> videos = new ArrayList<>();
        String sql = "SELECT * FROM videos";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                videos.add(new Video(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descripcion")
                        // Continúa con los demás atributos...
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return videos;
    }

    @Override
    public void guardar(Video video) {
        String sql = "INSERT INTO videos (titulo, descripcion) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, video.getTitulo());
            pstmt.setString(2, video.getDescripcion());
            // Continúa con los demás atributos...
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Video video) {
        String sql = "UPDATE videos SET titulo = ?, descripcion = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, video.getTitulo());
            pstmt.setString(2, video.getDescripcion());
            // Continúa con los demás atributos...
            pstmt.setInt(3, video.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM videos WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
