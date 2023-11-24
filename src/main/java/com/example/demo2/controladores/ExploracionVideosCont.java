package com.example.demo2.controladores;

import com.example.demo2.dao.VideoDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import com.example.demo2.modelo.Video;

public class ExploracionVideosCont {

    @FXML
    private ListView<Video> videosListView;

    private final VideoDAOImpl videoDAO = new VideoDAOImpl();

    @FXML
    private void initialize() {
        // Cargar la lista de videos al inicializar la ventana
        cargarListaVideos();
    }

    private void cargarListaVideos() {
        // Aquí iría la lógica para cargar los videos desde la base de datos
        // y añadirlos al ListView.
    }

    public void filtrarTodos(ActionEvent actionEvent) {
    }

    public void filtrarAccion(ActionEvent actionEvent) {
    }

    public void filtrarComedia(ActionEvent actionEvent) {
    }

    public void buscarVideos(ActionEvent actionEvent) {
    }
}
