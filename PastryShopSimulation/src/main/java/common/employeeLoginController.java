package common;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import team.nazah.cashier.Cashier;
import team.nazah.cashier.CashierDashboardController;

import java.io.IOException;
import java.util.ArrayList;

public class EmployeeLoginController
{
    @javafx.fxml.FXML
    private TextField employeeLoginName;
    @javafx.fxml.FXML
    private TextField employeeLoginPass;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }

    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent) throws IOException {
        String inputName = employeeLoginName.getText().trim();
        String inputPassword = employeeLoginPass.getText().trim();

        ArrayList<Cashier> cashiers = Cashier.loadCashiers();

        Cashier found = null;

        for (Cashier c : cashiers) {
            if (c.getName().equalsIgnoreCase(inputName) &&
                    c.getPassword().equals(inputPassword)) {

                found = c;
                break;
            }
        }

        if (found != null) {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/nazah/CashierDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            CashierDashboardController controller = fxmlLoader.getController();
            controller.receiveData(found);

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Invalid name or password.");
            alert.show();
        }
    }
}