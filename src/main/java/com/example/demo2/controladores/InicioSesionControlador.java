package com.example.demo2.controladores;

import com.example.demo2.controladores.DashboardControlador;
import com.example.demo2.controladores.RegistroUsuarioControlador;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

    public class InicioSesionControlador implements Initializable {
    Stage stage;
    @FXML
    private Text feedbackText;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ComboBox<String> planComboBox;

        @Override
        public void initialize(URL location, ResourceBundle resources) {

        }

    @FXML
    protected void onLoginButtonClick() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();


        // Lógica de inicio de sesión
        if (username.isEmpty() || password.isEmpty()) {
            feedbackText.setText("Por favor, ingresa tu nombre de usuario y contraseña.");
        } else {
            // Aquí iría la lógica para verificar las credenciales del usuario
            feedbackText.setText("Inicio de sesión exitoso.");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));


            //Cargar el controlador
            DashboardControlador dashboardControlador = new DashboardControlador();
            //Colocar el controlador al FXML
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

    @FXML
    protected void onRegisterLinkClick() throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegistroUsuario.fxml"));


        //Cargar el controlador
        RegistroUsuarioControlador registroUsuarioControlador = new RegistroUsuarioControlador();
        //Colocar el controlador al FXML
        fxmlLoader.setController(registroUsuarioControlador);

        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        registroUsuarioControlador.setStage(stage);
        stage.show();
        this.stage.close();

    }
        public void setStage(Stage stageA) {
            stage = stageA;

        }





    }