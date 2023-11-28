package com.example.demo2.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.example.demo2.modelo.CompraRenta;

import static com.example.demo2.MySQLConnection.getConnection;

public class CompraRentaDAO {
    Connection conn = getConnection();

    public List<CompraRenta> obtenerHistorial() {
        List<CompraRenta> historial = new ArrayList<>();
        String query = "SELECT fecha_compra_renta, titulo, tipo, costo FROM compras_rentas " +
                "INNER JOIN videos ON compras_rentas.id_video = videos.id_video";

        try (PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet resultSet = pstmt.executeQuery()) {

            while (resultSet.next()) {
                String fecha = resultSet.getString("fecha_compra_renta");
                String titulo = resultSet.getString("titulo");
                String tipo = resultSet.getString("tipo");
                double costo = resultSet.getDouble("costo");

                CompraRenta compraRenta = new CompraRenta(fecha, titulo, tipo, costo);
                historial.add(compraRenta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return historial;
    }

    // Métodos para agregar, actualizar, eliminar compras o rentas en la base de datos
    public void agregarCompraRenta(CompraRenta compraRenta) {
        String query = "INSERT INTO compras_rentas (id_usuario, id_video, fecha_compra_renta, costo) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, compraRenta.getIdUsuario());
            pstmt.setInt(2, compraRenta.getIdVideo());
            pstmt.setString(3, compraRenta.getFecha());
            pstmt.setDouble(4, compraRenta.getCosto());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void actualizarCompraRenta(int idCompraRenta, CompraRenta compraRentaActualizada) {
        String query = "UPDATE compras_rentas SET fecha_compra_renta = ?, costo = ? WHERE id_compra_renta = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, compraRentaActualizada.getFecha());
            pstmt.setDouble(2, compraRentaActualizada.getCosto());
            pstmt.setInt(3, idCompraRenta);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCompraRenta(int idCompraRenta) {
        String query = "DELETE FROM compras_rentas WHERE id_compra_renta = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idCompraRenta);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cerrarConexion() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
