package com.example.demo2.controladores;

import com.example.demo2.HelloApplication;
import com.example.demo2.dao.CompraRentaDAO;
import com.example.demo2.modelo.CompraRenta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HistorialComprasRentasControlador {
    Stage stage;
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
    @FXML
    protected void cargarDashboard() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Dashboard.fxml"));
        DashboardControlador dashboardControlador = new DashboardControlador();
        fxmlLoader.setController(dashboardControlador);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaximized(true);
        dashboardControlador.setStage(stage);
        stage.show();
        this.stage.close();

    }

    public void setStage(Stage stageA) {
        stage = stageA;
    }
}

