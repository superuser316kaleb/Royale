package com.example.demo2.controladores;

import com.example.demo2.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import com.example.demo2.modelo.Canal;
import com.example.demo2.dao.CanalDAOImpl;
import javafx.stage.Stage;

import java.io.IOException;

public class GestionCanalesControlador {
    Stage stage;
    @FXML
    private ListView<Canal> canalesListView;

    private final CanalDAOImpl canalDAO = new CanalDAOImpl();

    @FXML
    private void initialize() {
        // Cargar la lista de canales al inicializar la ventana
        cargarListaCanales();
    }

    private void cargarListaCanales() {
        // Aquí iría la lógica para cargar los canales desde la base de datos
        // y añadirlos al ListView.
    }
    public void crearCanal() {
        // Aquí iría la lógica para crear un nuevo canal.
    }


    public void eliminarCanal() {
        // Aquí iría la lógica para eliminar un canal.
    }
    public void subirVideo() {
        // Aquí iría la lógica para subir un nuevo video.

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
