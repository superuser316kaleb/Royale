package com.example.demo2.controladores;

import com.example.demo2.HelloApplication;
import com.example.demo2.cache.usuarioCache;
import com.example.demo2.modelo.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class DashboardControlador implements Initializable {
    Stage stage;
    private Usuario usuarioActual;

    @FXML
    Label lblUser;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblUser.setText(usuarioCache.getNombreUsuario());
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
    public void onFavClick() throws IOException {
        cargarReproductorVideos();
    }
    public void inicializarUsuario(Usuario usuario) {
        this.usuarioActual = usuario;
        // Accede al nombre de usuario y actualiza la interfaz gráfica
        lblUser.setText(usuario.getUsuario());
    }

    public void cargarReproductorVideos() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(   "ReproductorVideos.fxml"));
        //Cargar el controlador
        ReproductorVideosControlador reproductorVideosControlador = new ReproductorVideosControlador();
        //Colocar el controlador al FXML
        fxmlLoader.setController(reproductorVideosControlador);

        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        reproductorVideosControlador.setStage(stage);
        stage.show();
        this.stage.close();
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
}
