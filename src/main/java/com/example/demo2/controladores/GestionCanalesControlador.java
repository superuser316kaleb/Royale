package com.example.demo2.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import com.example.demo2.modelo.Canal;
import com.example.demo2.dao.CanalDAOImpl;
import javafx.stage.Stage;

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
    public void setStage(Stage stageA) {
        stage = stageA;
    }
}
