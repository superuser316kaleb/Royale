package com.example.demo2.controladores;

import com.example.demo2.HelloApplication;
import com.example.demo2.reportes.PdfFavoritos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ReportesFeedbackControlador {
    Stage stage;
    @FXML
    private TextArea feedbackTextArea;

    @FXML
    private void masVistosReporte() {
        // Aquí iría la lógica para generar el reporte de los videos más vistos.
    }
    @FXML
    public void mejorEvaluadosReporte() {
        try {
            File file = new File(DEST1);
            file.getParentFile().mkdirs();
            new PdfFavoritos().crearPdf(DEST1);
            openFile(DEST1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
    public static final String DEST1 = "results/pdf/lista de tareas.pdf";
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
    private void openFile(String filename) {
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(filename);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }
    }

}