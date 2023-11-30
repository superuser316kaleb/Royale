package com.example.demo2.controladores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;



public class DashboardControlador implements Initializable {
    Stage stage;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setStage(Stage stageA) {
         stage = stageA;

    }
    // Aquí puedes agregar métodos para manejar eventos específicos de la pantalla principal
}
