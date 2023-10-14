package cl.evolutec.tareas4v2;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

public class LoginController {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancelar;

    @FXML
    private PasswordField txtPass;

    @FXML
    private TextField txtUser;

    @FXML
    void terminarPrograma(ActionEvent event) {
        // Cierra la ventana actual
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

        // Cierra la aplicación JavaFX
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void verificarLogin(ActionEvent event) {
        String userN1 = "jorge";
        int passN1 = 1234;

        String userN2 = "ricardo";
        int passN2 = 1234;

        String txtuser = txtUser.getText();
        String txtpass = txtPass.getText();


        UserCredentials userCredentials = null;
        try {
            userCredentials = new UserCredentials(txtuser, txtpass);
        } catch (NumberFormatException e) {
            showAlert("Error", "Entrada inválida",
                    e.getMessage());

        }

        //Obtener datos de clase UserCredentials
        String user = "";
        int password = 0;
        try {
            user = userCredentials.getUsername();
            password = userCredentials.getPassword();
        } catch (NullPointerException e){
            //System.out.println(e.getMessage());
        }


        if(txtuser.equals(userN1) && password == passN1){
            showMessage("Acceso", "Acceso comprobado",
                    "Presione aceptar para continuar a Nivel 1");
        }
        else {
            if(txtuser.equals(userN2) && password == passN2){
                showMessage("Acceso", "Acceso comprobado",
                        "Presione aceptar para continuar a Nivel 2");
            }
            else {
                showMessage("Acceso", "Acceso invalido",
                        "Presione aceptar para seguir intentando");
            }
        }


        System.out.println("Usuario: " + txtuser);
        System.out.println("Contraseña: " + txtpass);

        txtUser.setText("");
        txtPass.setText("");
    }
    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void showMessage(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

}