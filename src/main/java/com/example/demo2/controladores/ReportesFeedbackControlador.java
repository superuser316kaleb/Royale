package com.example.demo2.controladores;

import com.example.demo2.HelloApplication;
import com.example.demo2.reportes.PdfCanales;
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
    public static final String DEST1 = "results/pdf/lista de tareas.pdf";
    public static final String DEST2 = "results/pdf/Reporte de canales.pdf";
    @FXML
    private TextArea feedbackTextArea;

    @FXML
    private void canalesReporte() {
        try {
            File file = new File(DEST2);
            file.getParentFile().mkdirs();
            new PdfCanales().crearPdf(DEST2);
            openFile(DEST2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public void setStage(Stage stageA) {
        stage = stageA;
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