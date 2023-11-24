    package com.example.demo2;

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

        @FXML
        private Text feedbackText;

        @FXML
        private TextField usernameField, nameField, emailField;

        @FXML
        private PasswordField passwordField;

        @FXML
        private ComboBox<String> planComboBox;

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

            // Lógica de inicio de sesión
            if (username.isEmpty() || password.isEmpty() || name.isEmpty() || email.isEmpty() || selectedPlan.isEmpty()) {
                feedbackText.setText("Por favor, llena todos los campos.");
            } else {
                // Aquí iría la lógica para verificar las credenciales del usuario
                feedbackText.setText("Inicio de sesión exitoso para el plan: " + selectedPlan);
            }
        }
        @FXML
        protected void onSelectPlanClick() {
            String selectedPlan = planComboBox.getValue();
            if (selectedPlan == null || selectedPlan.trim().isEmpty()) {
                feedbackText.setText("Por favor, selecciona un plan.");
            } else {
                feedbackText.setText("Plan seleccionado: " + selectedPlan);
            }
        }

    }