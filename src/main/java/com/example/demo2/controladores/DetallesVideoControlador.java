package com.example.demo2.controladores;

import com.example.demo2.dao.FavoritosDAOImpl;
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
    private final FavoritosDAOImpl favoritosDAO = new FavoritosDAOImpl(); // Instancia del DAO de favoritos
    private Video videoSeleccionado;
    private int idUsuarioActual = 1; // Por ejemplo, supongamos que el usuario actual tiene ID 1

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

    @FXML
    public void agregarAFavoritos(ActionEvent actionEvent) {
        /*if (videoSeleccionado != null) {
            int idVideo = videoSeleccionado.getId_video(); // Obtener el ID del video seleccionado

            // Suponiendo que tienes una lógica para generar un ID único para el favorito
            //int idFavorito = obtenerNuevoIdFavorito();

            // Llamar al método del DAO para agregar a favoritos
            if (favoritosDAO.agregarAFavoritos(idFavorito, idUsuarioActual, idVideo)) {
                System.out.println("El video se ha agregado a favoritos correctamente.");
            } else {
                System.out.println("Error al agregar el video a favoritos.");
            }
        }*/
    }



    // Otros métodos del controlador
}