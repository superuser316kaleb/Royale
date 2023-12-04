package com.example.demo2.controladores;

import com.example.demo2.HelloApplication;
import com.example.demo2.cache.usuarioCache;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import com.example.demo2.modelo.Usuario;
import com.example.demo2.dao.UsuarioDAOImpl;
import javafx.stage.Stage;

import java.io.IOException;

public class DetallesUsuarioControlador {
    Stage stage;
    @FXML
    private TextField nombreTextField;
    @FXML
    private TextField emailTextField;
    // Otros campos de la interfaz de usuario

     UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
    private Usuario usuarioActual;

    @FXML
    private void initialize() {
        //
        usuarioActual = usuarioDAO.obtenerPorUsuario(usuarioCache.getNombreUsuario());
        nombreTextField.setText(usuarioActual.getNombre());
        emailTextField.setText(usuarioActual.getEmail());
    }


    @FXML
    private void guardarCambios() {
        // Aquí iría la lógica para tomar los datos de los campos de texto
        // y actualizarlos en la base de datos.
    }

    public void setStage(Stage stageA) {
        stage = stageA;

    }
    @FXML
    protected void cargarDashboard() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(   "Dashboard.fxml"));
        //Cargar el controlador
        DashboardControlador dashboardControlador = new DashboardControlador();
        //Colocar el controlador al FXML
        fxmlLoader.setController(dashboardControlador);

        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        dashboardControlador.setStage(stage);
        stage.show();
        this.stage.close();

    }
}
