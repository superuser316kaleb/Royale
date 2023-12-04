package com.example.demo2.dao;

import com.example.demo2.MySQLConnection;
import com.example.demo2.modelo.Canal;
import com.example.demo2.modelo.Usuario;

import java.sql.*;
import java.util.*;


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

    public List<Map<Integer,String>> obtenerTodos() {

        List<Map<Integer,String>> lista = new ArrayList<Map<Integer,String>>();
        String sql = "select c.canal,u.nombre,u.apellido,u.domicilio,u.telefono,u.usuario,u.email " +
                "from canales c join usuarios u on c.id_usuario = u.id_usuario";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Map<Integer,String> map= new HashMap<>();
                map.put(1,rs.getString("canal"));
                map.put(2,rs.getString("nombre"));
                map.put(3,rs.getString("apellido"));
                map.put(4,rs.getString("domicilio"));
                map.put(5,rs.getString("telefono"));
                map.put(6,rs.getString("usuario"));
                map.put(7,rs.getString("email"));
                lista.add(map);
                //canales.add(canal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
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
