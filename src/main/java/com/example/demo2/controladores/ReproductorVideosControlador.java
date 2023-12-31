package com.example.demo2.controladores;

import com.example.demo2.HelloApplication;
import com.example.demo2.cache.videoCache;
import com.example.demo2.dao.VideoDAOImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PopupControl;
import javafx.scene.web.PopupFeatures;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReproductorVideosControlador implements Initializable {
    VideoDAOImpl videoDAO = new VideoDAOImpl();
    Stage stage;
    @FXML
    WebView webView;
    WebEngine webEngine;
    @FXML
    Label titulo;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String url = videoCache.getUrlVideo();
        titulo.setText(videoDAO.obtenerTituloPorURL(url.replace("\"", "")));
        cargarVideo(url.replace("\"", ""));

    }
    @FXML
    protected void cargarVideo(String url){
        webEngine = webView.getEngine();
        webEngine.load(url);
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

}
