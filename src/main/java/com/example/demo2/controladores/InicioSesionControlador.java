package com.example.demo2.controladores;

import com.example.demo2.HelloApplication;
import com.example.demo2.cache.usuarioCache;
import com.example.demo2.dao.UsuarioDAOImpl;
import com.example.demo2.modelo.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import static com.example.demo2.MySQLConnection.getConnection;

public class InicioSesionControlador implements Initializable {
        UsuarioDAOImpl usuDao = new UsuarioDAOImpl();
        Usuario usuario = new Usuario();
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
            passwordField.setText("takemeho");
            usernameField.setText("master_chief");

        }

    @FXML
    protected void onLoginButtonClick() throws IOException {
        String username = usernameField.getText();
        usuarioCache.setNombreUsuario(username);
        String password = passwordField.getText();



        // Lógica de inicio de sesión
        if (username.isEmpty() || password.isEmpty()) {
            feedbackText.setText("Por favor, ingresa tu nombre de usuario y contraseña.");
        } else {
            // Aquí iría la lógica para verificar las credenciales del usuario
            if(usuDao.InicioSesion(username,password).isEmpty()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Report");
                alert.setContentText("Usuario y/o contraseña incorrectos");
                alert.show();
            }else {
                feedbackText.setText("Inicio de sesión exitoso.");
               cargarDashboard();
            }
        }
    }

    @FXML
    protected void onRegisterLinkClick() throws IOException {
            cargarRegistro();
    }
        @FXML
        protected void cargarDashboard() throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(   "Dashboard.fxml"));
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
        @FXML
        protected void cargarRegistro() throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(   "RegistroUsuario.fxml"));
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