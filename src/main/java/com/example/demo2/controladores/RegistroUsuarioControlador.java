    package com.example.demo2.controladores;

    import com.example.demo2.HelloApplication;
    import com.example.demo2.MySQLConnection;
    import com.example.demo2.dao.UsuarioDAOImpl;
    import com.example.demo2.modelo.Tarjeta;
    import com.example.demo2.modelo.Usuario;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.fxml.Initializable;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.ComboBox;
    import javafx.scene.control.PasswordField;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.VBox;
    import javafx.scene.text.Text;
    import javafx.stage.Stage;

    import java.io.IOException;
    import java.net.URL;
    import java.sql.Connection;
    import java.util.ResourceBundle;

    public class RegistroUsuarioControlador implements Initializable {



        public TextField cardField;
        public TextField dateField;
        public TextField cvvField,addressField,phoneField,lastnameField;
        @FXML
        private Text feedbackText;

        @FXML
        private TextField usernameField, nameField, emailField;

        @FXML
        private PasswordField passwordField,passwordField2;

        @FXML
        private ComboBox<String> planComboBox,methodComboBox;

        @FXML
                private HBox secondMain;
        @FXML
        VBox vboxsubscripciones;
        Stage stage;

        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();

        Connection conn = MySQLConnection.getConnection();
        @Override
        public void initialize(URL location, ResourceBundle resources) {
            //ocultamos la parte del pago
            if (planComboBox.getValue()==null) vboxsubscripciones.setVisible(false);

        }


        @FXML
        protected void selectionClick(ActionEvent actionEvent) {
            String selectedPlan = planComboBox.getValue();
            if (selectedPlan.equals("Premium")){
                vboxsubscripciones.setVisible(true);
            }else if (selectedPlan.equals("Básico")){
                vboxsubscripciones.setVisible(true);
            }else{
                vboxsubscripciones.setVisible(false);
            }
        }
        @FXML
        public void onSignInButtonClick(ActionEvent actionEvent) throws IOException {
            String usuario = usernameField.getText();
            String contrasena = passwordField.getText();
            String nombre = nameField.getText();
            String apellido = lastnameField.getText();
            String email = emailField.getText();
            String selectedPlan = planComboBox.getValue();
            String domicilio = addressField.getText();
            String telefono = phoneField.getText();
            String password2 = passwordField2.getText();

            String selectedMethod = methodComboBox.getValue();
            String card = cardField.getText();
            String date = dateField.getText();
            String cvv = cvvField.getText();

            // Lógica de inicio de sesión
            if (usuario.isEmpty() || contrasena.isEmpty() || nombre.isEmpty() || email.isEmpty()
                    || selectedPlan.isEmpty()|| password2.isEmpty()|| domicilio.isEmpty()|| telefono.isEmpty()|| apellido.isEmpty()) {
                    feedbackText.setText("Por favor, llena todos los campos.");
            } else {
                if (contrasena.equals(password2)||selectedPlan.equals("Visitante")) {
                    feedbackText.setText("Registro exitoso para " + selectedPlan);
                    feedbackText.setText("Creación de usuario "+selectedPlan+" exitosa.");
                    usuarioDAO.save(getUserInfo());
                    cargarInicio();
                } else {
                    feedbackText.setText("Las contraseñas no coinciden.");
                    limpiarCampos();
                } if (selectedPlan.equals("Premium")||selectedPlan.equals("Básico")||contrasena.equals(password2)) {
                    if (card.isEmpty() || date.isEmpty() || cvv.isEmpty()|| selectedMethod.isEmpty()) {
                        feedbackText.setText("Por favor, llena todos los campos.");
                        limpiarCampos();
                    } else {
                        feedbackText.setText("Registro exitoso para plan " + selectedPlan);
                        feedbackText.setText("Creación de usuario "+selectedPlan+" exitosa.");
                        usuarioDAO.save(getUserInfo());
                        if (methodComboBox.getValue().equals("Crédito")) {
                            usuarioDAO.saveTarjeta(getTarjetaInfo(1));
                        } else if (methodComboBox.getValue().equals("Débito")) {
                            usuarioDAO.saveTarjeta(getTarjetaInfo(2));
                        }
                        cargarInicio();
                    }
                }
            }
        }

        @FXML
        protected void cargarInicio() throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(   "hello-view.fxml"));
            //Cargar el controlador
            InicioSesionControlador inicioSesionControlador = new InicioSesionControlador();
            //Colocar el controlador al FXML
            fxmlLoader.setController(inicioSesionControlador);

            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            inicioSesionControlador.setStage(stage);
            stage.show();
            this.stage.close();

        }
        protected Usuario getUserInfo(){
            String usuario = usernameField.getText();
            String contrasena = passwordField.getText();
            String nombre = nameField.getText();
            String apellido = lastnameField.getText();
            String email = emailField.getText();
            String selectedPlan = planComboBox.getValue();
            String domicilio = addressField.getText();
            String telefono = phoneField.getText();
            int id_suscripcion =1;
            String tipo_usuario="usuario";
            if (selectedPlan.equals("Premium")){
                id_suscripcion=3;
            }else if (selectedPlan.equals("Básico")){
                id_suscripcion=2;
            }
            Usuario usuario1 = new Usuario();
            usuario1.setUsuario(usuario);
            usuario1.setContrasena(contrasena);
            usuario1.setNombre(nombre);
            usuario1.setApellido(apellido);
            usuario1.setEmail(email);
            usuario1.setTipo_usuario(tipo_usuario);
            usuario1.setDomicilio(domicilio);
            usuario1.setTelefono(telefono);
            usuario1.setId_tipo_suscripcion(id_suscripcion);


            return usuario1;
        }
        protected Tarjeta getTarjetaInfo(int metodo){
            String card = cardField.getText();
            String date = dateField.getText();
            int cvv = Integer.parseInt(cvvField.getText());
            Tarjeta tarjeta = new Tarjeta();
            tarjeta.setId_usuario(usuarioDAO.getNextSequence());
            tarjeta.setId_metodo(metodo);
            tarjeta.setTerminacion(Integer.parseInt(obtenerTerminacion(card)));
            tarjeta.setCvv(cvv);
            tarjeta.setFecha_caducidad(date);
            return tarjeta;
        }
        protected void limpiarCampos(){
            passwordField.setText("");
            passwordField2.setText("");
        }
        public void setStage(Stage stageA) {
                 stage = stageA;

            }

        private static String obtenerTerminacion(String tarjeta) {
            if (tarjeta.length() >= 4) {
                // Obtener los últimos 4 dígitos
                return tarjeta.substring(tarjeta.length() - 4);
            } else {
                return "";
            }
        }

    }