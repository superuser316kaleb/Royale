    package com.example.demo2;

    import com.example.demo2.modelo.Usuario;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.Initializable;
    import javafx.scene.control.ComboBox;
    import javafx.scene.control.PasswordField;
    import javafx.scene.control.TextField;
    import javafx.scene.text.Text;

    import java.net.URL;
    import java.util.ResourceBundle;

    public class RegistroUsuarioControlador implements Initializable {



        public TextField cardField;
        public TextField dateField;
        public TextField cvvField;
        @FXML
        private Text feedbackText;

        @FXML
        private TextField usernameField, nameField, emailField;

        @FXML
        private PasswordField passwordField,passwordField2;

        @FXML
        private ComboBox<String> planComboBox,methodComboBox;

        @Override
        public void initialize(URL location, ResourceBundle resources) {

        }

        @FXML
        public void onSignInButtonClick(ActionEvent actionEvent) {
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
                } else {
                    feedbackText.setText("Las contraseñas no coinciden.");
                    limpiarCampos();
                }
            }
        }
        protected void getUserInfo(){
            String username = usernameField.getText();
            String password = passwordField.getText();
            String name = nameField.getText();
            String email = emailField.getText();
            String selectedPlan = planComboBox.getValue();
            Usuario usuario = new Usuario();
            usuario.setNombre(name);
            usuario.setEmail(email);
            usuario.setPassword(password);
            usuario.setMetodoPago(Integer.parseInt(methodComboBox.getValue()));
            usuario.setTelefono(Integer.parseInt(cardField.getText()));
            usuario.setDireccion(dateField.getText());
            usuario.setId_subscription(Integer.parseInt(cvvField.getText()));

        }
        protected void limpiarCampos(){
            passwordField.setText("");
            passwordField2.setText("");
        }

    }