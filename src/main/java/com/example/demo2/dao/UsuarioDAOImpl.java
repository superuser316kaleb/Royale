package com.example.demo2.dao;

import com.example.demo2.MySQLConnection;
import com.example.demo2.modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.demo2.MySQLConnection.getConnection;

public class UsuarioDAOImpl extends MySQLConnection implements Dao<Usuario> {

Connection conn = getConnection();


    public Usuario obtenerPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                // Set other fields...
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Usuario> obtenerTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                // Set other fields...
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }



    public void actualizar(Usuario usuario) {

    }



    @Override
    public Optional<Usuario> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Usuario> findAll() {
        return null;
    }

    @Override
    public boolean save(Usuario usuario) {
        String query = "insert into usuarios (nombre, apellido, domicilio, telefono, id_tipo_suscripcion, contrasena, email, usuario)" +
                "values (?, ?, ?, ?, ?, ?, ?, ?);";
        try (
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getApellido());
            pstmt.setString(3, usuario.getDomicilio());
            pstmt.setString(4, usuario.getTelefono());
            pstmt.setInt(5, usuario.getId_tipo_suscripcion());
            pstmt.setString(6, usuario.getContrasena());
            pstmt.setString(7, usuario.getEmail());
            pstmt.setString(8, usuario.getUsuario());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } return false;
    }

    @Override
    public boolean update(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, email = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setInt(3, usuario.getId_usuario());
            // Set other fields...
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }


}
