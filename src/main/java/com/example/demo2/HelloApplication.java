package com.example.demo2;

import com.example.demo2.controladores.InicioSesionControlador;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        InicioSesionControlador inicioSesionControlador= new InicioSesionControlador();
        fxmlLoader.setController(inicioSesionControlador);
        Scene scene = new Scene(fxmlLoader.load(), 420, 340);
        stage.setTitle("Royale");
        stage.setScene(scene);
        stage.show();
        inicioSesionControlador.setStage(stage);


    }

    public static void main(String[] args) {
        launch();
    }
}