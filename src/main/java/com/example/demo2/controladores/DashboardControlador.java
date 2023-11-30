package com.example.demo2.controladores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardControlador implements Initializable {
    Stage stage;
    @FXML
    private HBox hboxRecomendaciones;

    @FXML
    private ScrollPane scrollRecomendaciones;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarCarrusel();
    }

    private void cargarCarrusel() {
        // Los nombres de las imágenes han sido actualizados
        String[] imagenes = { "imagen1.png", "imagen2.png", "imagen3.png" };

        for (String imagenNombre : imagenes) {
            ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/imagenes/" + imagenNombre)));
            imageView.setPreserveRatio(true);
            imageView.setFitHeight(100); // Ajusta la altura como necesites

            Hyperlink hyperlink = new Hyperlink();
            hyperlink.setGraphic(imageView);
            hyperlink.setOnAction(event -> {
                // Acción al hacer clic en la imagen
                System.out.println("Imagen " + imagenNombre + " clickeada");
                // Aquí puedes abrir un enlace o realizar otra acción
            });

            hboxRecomendaciones.getChildren().add(hyperlink);
        }

        // Ajusta el ScrollPane para que se ajuste al ancho y solo muestre la barra de desplazamiento horizontal cuando sea necesario
        scrollRecomendaciones.setFitToWidth(true);
        scrollRecomendaciones.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }
    public void setStage(Stage stageA) {
        stage = stageA;

    }
}

