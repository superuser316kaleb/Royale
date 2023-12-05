package com.example.demo2.dao;

import com.example.demo2.MySQLConnection;
import com.example.demo2.modelo.Video;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VideoDAOImpl extends MySQLConnection implements Dao<Video>{

    Connection conn = getConnection();
//    public Video obtenerPorId(int id) {
//        String sql = "SELECT * FROM videos WHERE id = ?";
//        try (Connection conn = getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, id);
//            ResultSet rs = pstmt.executeQuery();
//            if (rs.next()) {
//                return new Video(
//                        rs.getInt("id"),
//                        rs.getString("titulo"),
//                        rs.getString("descripcion")
//                        // Continúa con los demás atributos...
//                );
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

//    public List<Video> obtenerTodos() {
//        List<Video> videos = new ArrayList<>();
//        String sql = "SELECT * FROM videos";
//        try (Connection conn = getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//            while (rs.next()) {
//                videos.add(new Video(
//                        rs.getInt("id"),
//                        rs.getString("titulo"),
//                        rs.getString("descripcion")
//                        // Continúa con los demás atributos...
//                ));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return videos;
//    }

   /*/ public  void insertImage(String rutaImagen, int idVideo) {
        try {


            // lee el archivo como arreglo de bytes
            File archivoImagen = new File(rutaImagen);
            try (FileInputStream inputStream = new FileInputStream(archivoImagen)) {
                byte[] imagenComoBytes = new byte[(int) archivoImagen.length()];
                inputStream.read(imagenComoBytes);

                //  la consulta SQL
                String consultaSQL = "UPDATE videos SET imagen = ? WHERE id_video = ?";
                PreparedStatement declaracion = conn.prepareStatement(consultaSQL);

                // parámetros para la consulta
                declaracion.setBytes(1, imagenComoBytes);
                declaracion.setInt(2, idVideo);

                // Ejecuta la consulta
                declaracion.executeUpdate();

                System.out.println("Imagen insertada correctamente en la base de datos.");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
    */
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
    public List<String> obtenerRutasImagenesDeBD() {
        List<String> rutas = new ArrayList<>();
        String sql = "SELECT imagen FROM videos where imagen is not null and id_video <=12";
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                rutas.add(rs.getString("imagen"));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return rutas;
    }public List<String> obtenerRutasImagenesComedia() {
        List<String> rutas = new ArrayList<>();
        String sql = "SELECT imagen FROM videos where imagen is not null and id_categoria=5";
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                rutas.add(rs.getString("imagen"));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return rutas;
    }
    public List<String> obtenerURLS() {
        List<String> url = new ArrayList<>();
        String sql = "SELECT url FROM videos where imagen is not null and id_video<=12";
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                url.add(rs.getString("url"));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return url;
    }
    public List<String> obtenerURLSComedia() {
        List<String> url = new ArrayList<>();
        String sql = "SELECT url FROM videos where imagen is not null and id_categoria=5 ";
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                url.add(rs.getString("url"));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return url;
    }

    public String obtenerTituloPorURL(String url) {
        String titulo = "";
        String sql = "SELECT titulo FROM videos where url = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, url);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                titulo = rs.getString("titulo");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return titulo;
    }

    public void actualizar(Video video) {
        String sql = "UPDATE videos SET titulo = ?, descripcion = ? WHERE id = ?";
        try (
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, video.getTitulo());
            pstmt.setString(2, video.getDescripcion());
            // Continúa con los demás atributos...
           // pstmt.setInt(3, video.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


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


    @Override
    public Optional<Video> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Video> findAll() {
        return null;
    }

    @Override
    public boolean save(Video record) {
        return false;
    }

    @Override
    public boolean update(Video record) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
