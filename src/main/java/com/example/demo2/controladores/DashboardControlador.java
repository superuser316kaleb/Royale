package com.example.demo2.controladores;

import com.example.demo2.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
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

    @FXML
    public void onReportClick(){

    }
    @FXML
    public void oncanalesClick(){

    }
    @FXML
    public void onSalesClick(){

    }
    @FXML
    public void onFavClick(){

    }

    @FXML
    public void cargarDetallesUsuario() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(   "DetallesUsuario.fxml"));
        DetallesUsuarioControlador detallesUsuarioControlador = new DetallesUsuarioControlador();
        fxmlLoader.setController(detallesUsuarioControlador);

        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        detallesUsuarioControlador.setStage(stage);
        stage.show();
        this.stage.close();
    }
    // Aquí puedes agregar métodos para manejar eventos específicos de la pantalla principal
}
