package com.example.demo2.controladores;

import com.example.demo2.HelloApplication;
import com.example.demo2.MySQLConnection;
import com.example.demo2.cache.usuarioCache;
import com.example.demo2.modelo.Tarjeta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.example.demo2.modelo.Usuario;
import com.example.demo2.dao.UsuarioDAOImpl;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class DetallesUsuarioControlador {
    Stage stage;
    @FXML
    private TextField nombreTextField,apellidoTextField,domicilioTextField,contrasenaTextField1;
    @FXML
    private TextField emailTextField;
    @FXML
    Label lblusuario,lblsuscripcion,lblterminacion,lbltipo;
    // Otros campos de la interfaz de usuario

     UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
     Tarjeta tarjeta = new Tarjeta();
    private Usuario usuarioActual;


    @FXML
    private void initialize() {
        usuarioActual = usuarioDAO.obtenerPorUsuario(usuarioCache.getNombreUsuario());
       // tarjeta = usuarioDAO.getTarjetaById_usuario(usuarioActual.getId_usuario());
        nombreTextField.setText(usuarioActual.getNombre());
        apellidoTextField.setText(usuarioActual.getApellido());
        emailTextField.setText(usuarioActual.getEmail());
        domicilioTextField.setText(usuarioActual.getDomicilio());
        contrasenaTextField1.setText(usuarioActual.getContrasena());
        lblusuario.setText(usuarioActual.getUsuario());
        if (usuarioActual.getId_tipo_suscripcion()==1){
            lblsuscripcion.setText("Visistante");
        }else if (usuarioActual.getId_tipo_suscripcion()==2){
            lblsuscripcion.setText("Basic");
        }else if (usuarioActual.getId_tipo_suscripcion()==3){
            lblsuscripcion.setText("Premium");
        }
       lblterminacion.setText("xxxx-xxxx-xxxx-"+ usuarioCache.getTarjetaterminacion());
        lbltipo.setText(usuarioCache.getTipoTarjeta());
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
