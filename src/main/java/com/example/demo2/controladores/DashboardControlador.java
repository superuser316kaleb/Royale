package com.example.demo2.controladores;

import com.example.demo2.HelloApplication;
import com.example.demo2.cache.usuarioCache;
import com.example.demo2.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



public class DashboardControlador implements Initializable {
    Stage stage;
    private Usuario usuarioActual;
    private FlowPane panelRecomendaciones;

    @FXML
    Button btnInfo, btnCanales, btnfavorites, btnSalesReport, btnReports;
    @FXML
    Label lblUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblUser.setText(usuarioCache.getNombreUsuario());
        btnInfo.setOnAction(handlerButtons);
        btnCanales.setOnAction(handlerButtons);
        btnfavorites.setOnAction(handlerButtons);
        btnSalesReport.setOnAction(handlerButtons);
        btnReports.setOnAction(handlerButtons);
        cargarImagenesRecomendadas();
    }

    EventHandler<ActionEvent> handlerButtons = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == btnInfo) {
                try {
                    cargarDetallesUsuario();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            } else if (event.getSource() == btnCanales) {
                try {
                    showcanales();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (event.getSource() == btnfavorites) {
                try {
                    cargarReproductorVideos();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (event.getSource() == btnSalesReport) {
                try {
                    compra_renta();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (event.getSource() == btnReports) {
                try {
                    reports();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    };

    public void setStage(Stage stageA) {
        stage = stageA;

    }

    @FXML
    public void onReportClick() {

    }

    @FXML
    public void oncanalesClick() {

    }

    @FXML
    public void onSalesClick() {

    }

    @FXML
    public void onExitClick() {

    }

    @FXML
    public void onFavClick() throws IOException {
        cargarReproductorVideos();
    }

    public void inicializarUsuario(Usuario usuario) {
        this.usuarioActual = usuario;
        // Accede al nombre de usuario y actualiza la interfaz gráfica
        lblUser.setText(usuario.getUsuario());
    }

    public void cargarReproductorVideos() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ReproductorVideos.fxml"));
        ReproductorVideosControlador reproductorVideosControlador = new ReproductorVideosControlador();
        fxmlLoader.setController(reproductorVideosControlador);

        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setMaximized(true);
        reproductorVideosControlador.setStage(stage);
        stage.show();
        this.stage.close();
    }

    @FXML
    public void cargarDetallesUsuario() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DetallesUsuario.fxml"));
        DetallesUsuarioControlador detallesUsuarioControlador = new DetallesUsuarioControlador();
        fxmlLoader.setController(detallesUsuarioControlador);

        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        detallesUsuarioControlador.setStage(stage);
        stage.show();
        this.stage.close();
    }

    public void reports() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ReportesFeedback.fxml"));
        ReportesFeedbackControlador reportesFeedbackControlador = new ReportesFeedbackControlador();
        fxmlLoader.setController(reportesFeedbackControlador);

        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        reportesFeedbackControlador.setStage(stage);
        stage.show();
        this.stage.close();
    }

    public void compra_renta() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("HistorialComprasRentas.fxml"));
        HistorialComprasRentasControlador historialComprasRentasControlador = new HistorialComprasRentasControlador();
        fxmlLoader.setController(historialComprasRentasControlador);

        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaximized(true);
        historialComprasRentasControlador.setStage(stage);
        stage.show();
        this.stage.close();
    }
    public void showcanales() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("GestionCanales.fxml"));
        GestionCanalesControlador gestionCanalesControlador = new  GestionCanalesControlador();
        fxmlLoader.setController(gestionCanalesControlador);

        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        gestionCanalesControlador.setStage(stage);
        stage.show();
        this.stage.close();
}
    private void cargarImagenesRecomendadas() {

        List<String> rutasImagenes = obtenerRutasImagenesDeBD();

        for (String ruta : rutasImagenes) {
            Image imagen = new Image("file:" + ruta);
            ImageView imageView = new ImageView(imagen);
            imageView.setFitWidth(150); // tamaño
            imageView.setFitHeight(100); // tamaño
            imageView.setPreserveRatio(true);
            panelRecomendaciones.getChildren().add(imageView);
        }
    }
    private List<String> obtenerRutasImagenesDeBD() {
        List<String> rutas = new ArrayList<>();
        String sql = "SELECT ruta_columna FROM tu_tabla_imagenes";
        try (Connection conn = tuMetodoParaConectarALaBaseDeDatos();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                rutas.add(rs.getString("ruta_columna"));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return rutas;
    }
}
