package com.example.demo2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;

    public class InicioSesionControlador implements Initializable {

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
    protected void onLoginButtonClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();


        // Lógica de inicio de sesión
        if (username.isEmpty() || password.isEmpty()) {
            feedbackText.setText("Por favor, ingresa tu nombre de usuario y contraseña.");
        } else {
            // Aquí iría la lógica para verificar las credenciales del usuario

        }
    }

    @FXML
    protected void onRegisterLinkClick() {
        // Lógica para ir a la pantalla de registro
        feedbackText.setText("Pantalla de registro no implementada.");
    }




    }