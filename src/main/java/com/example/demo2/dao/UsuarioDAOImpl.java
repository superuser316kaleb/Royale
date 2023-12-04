package com.example.demo2.dao;

import com.example.demo2.MySQLConnection;
import com.example.demo2.modelo.Tarjeta;
import com.example.demo2.modelo.Usuario;
import javafx.beans.binding.StringExpression;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.example.demo2.MySQLConnection.getConnection;

public class UsuarioDAOImpl extends MySQLConnection implements Dao<Usuario> {

    Connection conn = MySQLConnection.getConnection();


    public Usuario obtenerPorUsuario(String nusuario) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ?";
        try (
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nusuario);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setDomicilio(rs.getString("domicilio"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setId_tipo_suscripcion(rs.getInt("id_tipo_suscripcion"));
                usuario.setTipo_usuario(rs.getString("tipo_usuario"));
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
        try (
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
    public void saveTarjeta(Tarjeta tarjetaInfo) {
        String query = "insert into usuario_metodo (id_usuario, id_metodo, terminacion, cvv, fecha_caducidad)" +
                "values (?, ?, ?, ?, ?);";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, tarjetaInfo.getId_usuario());
            pstmt.setInt(2, tarjetaInfo.getId_metodo());
            pstmt.setInt(3, tarjetaInfo.getTerminacion());
            pstmt.setInt(4, tarjetaInfo.getCvv());
            pstmt.setString(5, tarjetaInfo.getFecha_caducidad());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getNextSequence(){
        String query= "select max(last_insert_id(id_usuario))+1 from usuarios;";
        int next=0;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                next = rs.getInt(1);
            }
        }   catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return next;
    }

    public Tarjeta getTarjetaById_usuario(int id_usuario) {
        String query = "select * from usuario_metodo where id_usuario = ?;";
        Tarjeta tarjeta = new Tarjeta();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id_usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tarjeta.setId_usuario(rs.getInt("id_usuario"));
                tarjeta.setId_metodo(rs.getInt("id_metodo_pago"));
                tarjeta.setTerminacion(rs.getInt("terminacion"));
                tarjeta.setCvv(rs.getInt("cvv"));
                tarjeta.setFecha_caducidad(rs.getString("fecha_caducidad"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tarjeta;
    }

    @Override
    public boolean update(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, email = ? WHERE id = ?";
        try (
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


    public String InicioSesion(String username, String password) {
        String tipo="";
        String sql= "select usuarios.tipo_usuario from usuarios" +
                "    where usuarios.usuario=? and usuarios.contrasena=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(!rs.isBeforeFirst()){
                tipo="";
            }else{
                rs.next();
                tipo = rs.getString(1).toString();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tipo;
    }
}
