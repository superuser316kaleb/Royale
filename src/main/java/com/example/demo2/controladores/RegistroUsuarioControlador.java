    package com.example.demo2.controladores;

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
    import javafx.scene.text.Text;
    import javafx.stage.Stage;

    import java.io.IOException;
    import java.net.URL;
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
        Stage stage;
        @Override
        public void initialize(URL location, ResourceBundle resources) {

        }

        @FXML
        public void onSignInButtonClick(ActionEvent actionEvent) throws IOException {
            String username = usernameField.getText();
            String password = passwordField.getText();
            String name = nameField.getText();
            String email = emailField.getText();
            String selectedPlan = planComboBox.getValue();
            String password2 = passwordField2.getText();

            // Lógica de inicio de sesión
            if (username.isEmpty() || password.isEmpty() || name.isEmpty() || email.isEmpty()
                    || selectedPlan.isEmpty()|| password2.isEmpty()) {
                    feedbackText.setText("Por favor, llena todos los campos.");
            } else {
                if (password.equals(password2)) {
                    feedbackText.setText("Registro exitoso para el plan: " + selectedPlan);
                    // Aquí iría la lógica para verificar las credenciales del usuario
                    feedbackText.setText("Creación de usuario "+selectedPlan+" exitosa.");
                    //cargarDashboard();

                } else {
                    feedbackText.setText("Las contraseñas no coinciden.");
                    limpiarCampos();
                }
            }
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
            int tipo_usuario=1;
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
            usuario1.setTipo_usuario(tipo_usuario);

            return usuario1;
        }
        protected void limpiarCampos(){
            passwordField.setText("");
            passwordField2.setText("");
        }
            public void setStage(Stage stageA) {
                 stage = stageA;

            }

        @FXML
        protected void cargarDashboard() throws IOException {


            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("com/example/demo2/Dashboard.fxml"));


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