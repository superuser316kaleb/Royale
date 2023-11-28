package com.example.demo2.controladores;

import com.example.demo2.dao.CompraRentaDAO;
import com.example.demo2.modelo.CompraRenta;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class HistorialComprasRentasControlador {
    @FXML
    private DatePicker fechaInicioPicker;

    @FXML
    private DatePicker fechaFinPicker;

    @FXML
    private Button filtrarButton;

    @FXML
    private TableView<CompraRenta> historialTableView;

    @FXML
    private TableColumn<CompraRenta, String> columnaFecha;

    @FXML
    private TableColumn<CompraRenta, String> columnaTitulo;

    @FXML
    private TableColumn<CompraRenta, String> columnaTipo;

    @FXML
    private TableColumn<CompraRenta, Double> columnaCosto;

    private CompraRentaDAO compraRentaDAO;

    public HistorialComprasRentasControlador() {
        this.compraRentaDAO = new CompraRentaDAO();
    }

    @FXML
    private void initialize() {

        columnaFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        columnaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        columnaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnaCosto.setCellValueFactory(new PropertyValueFactory<>("costo"));

        cargarDatos();
    }

    private void cargarDatos() {

        List<CompraRenta> historial = compraRentaDAO.obtenerHistorial();
        historialTableView.getItems().addAll(historial);
    }

    @FXML
    private void filtrarHistorial() {

    }


}

