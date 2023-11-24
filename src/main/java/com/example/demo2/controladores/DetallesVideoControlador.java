package com.example.demo2.controladores;

import com.example.demo2.dao.VideoDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import com.example.demo2.modelo.Video;

public class DetallesVideoControlador {

    @FXML
    private Label tituloLabel;
    @FXML
    private Button rentarButton;
    // Otros elementos de la interfaz de usuario

    private final VideoDAOImpl videoDAO = new VideoDAOImpl();
    private Video videoSeleccionado;

    @FXML
    private void initialize() {
        // Cargar los detalles del video seleccionado al inicializar la ventana
        cargarDetallesVideo();
    }

    private void cargarDetallesVideo() {
        // Aquí iría la lógica para cargar los detalles del video desde la base de datos
        // y mostrarlos en la interfaz de usuario.
    }

    @FXML
    private void rentarVideo() {
        // Aquí iría la lógica para rentar el video seleccionado.
    }

    public void agregarAFavoritos(ActionEvent actionEvent) {
    }
}
