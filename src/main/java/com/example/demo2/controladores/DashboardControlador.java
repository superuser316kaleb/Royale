package com.example.demo2.controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class DashboardControlador implements Initializable {
    @FXML
    private Button btnCanales,btnfavorites,btnSalesReport,btnReports;

    Stage stage;

    public DashboardControlador() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnCanales.setOnAction(event -> {
           oncanalesClick();
        });
        btnfavorites.setOnAction(event -> {
            onFavClick();
        });
        btnReports.setOnAction(event -> {
            onSalesClick();
        });
        btnReports.setOnAction(event -> {
            onReportClick();
        });


    }

    public void setStage(Stage stageA) {
         stage = stageA;

    }
    // Aquí puedes agregar métodos para manejar eventos específicos de la pantalla principal
    @FXML
    public void oncanalesClick(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GestionCanales.fxml"));
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toString());
            stage.setMaximized(true);
            stage.setTitle("Messages");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void onFavClick(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ExploracionVideos.fxml"));
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toString());
            stage.setMaximized(true);
            stage.setTitle("Messages");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public void onSalesClick(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HistorialComprasRentas.fxml"));
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toString());
            stage.setMaximized(true);
            stage.setTitle("Messages");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void onReportClick(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReportesFeedback.fxml"));
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toString());

            stage.setTitle("Info");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}
