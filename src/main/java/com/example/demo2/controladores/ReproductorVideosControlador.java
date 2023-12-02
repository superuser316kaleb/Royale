package com.example.demo2.controladores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PopupControl;
import javafx.scene.web.PopupFeatures;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ReproductorVideosControlador implements Initializable {
    Stage stage;
    @FXML
    WebView webView;
    WebEngine webEngine;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarVideo();
    }
    protected void cargarVideo(){
        webEngine = webView.getEngine();
        webEngine.load("https://www.youtube.com/embed/2Vv-BfVoq4g");
    }
    public void setStage(Stage stageA) {
        stage = stageA;

    }

}
