package com.example.demo2.controladores;

import com.example.demo2.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ReportesFeedbackControlador {
    Stage stage;

    @FXML
    private TextArea feedbackTextArea;

    @FXML
    private void enviarFeedback() {
        // Aquí iría la lógica para enviar el feedback o reporte a la base de datos
        // o al sistema de gestión de

    }

    public void setStage(Stage stageA) {
        stage = stageA;
    }
    @FXML
    protected void cargarDashboard() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(   "Dashboard.fxml"));
        //Cargar el controlador
        DashboardControlador dashboardControlador = new DashboardControlador();
        //Colocar el controlador al FXML
        fxmlLoader.setController(dashboardControlador);

        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        dashboardControlador.setStage(stage);
        stage.show();
        this.stage.close();

    }
}