package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    AnchorPane apVentana;
    @FXML
    TextField txtUsuario;
    @FXML
    PasswordField txtContrasena;
    @FXML
    Button btnLogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void login() {
        String usuario = txtUsuario.getText().trim();
        String contrasena = txtContrasena.getText().trim();

        if (usuario.equals("") || contrasena.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Falta algun campo");
            alert.showAndWait();
        } else {
            Database db = new Database();
            Connection conexion = db.obtenerConexion();

            String consulta = "SELECT * FROM usuarios WHERE usuario='" + usuario + "' AND contrasena='" + contrasena + "'";

            Usuario user;

            try {
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(consulta);

                if (!rs.next()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("ERROR");
                    alert.setContentText("No hay registro con esos datos");
                    alert.showAndWait();
                } else {
                    do {
                        user = new Usuario(
                                rs.getInt("idUsuario"),
                                rs.getString("nombre"),
                                rs.getString("usuario"),
                                rs.getString("contrasena")
                        );
                    } while (rs.next());

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("AVISO");
                    alert.setContentText("LOGIN EXITOSO \n" + user.mostrarUsuario());
                    alert.showAndWait();
                }

                rs.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
