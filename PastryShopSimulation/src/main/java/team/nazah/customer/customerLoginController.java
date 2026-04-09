package team.nazah.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

import static team.nazah.customer.Customer.loadCustomers;

public class CustomerLoginController
{
    @javafx.fxml.FXML
    private TextField customerLoginName;

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
    public void customerLoginButtonOnAction(ActionEvent actionEvent) throws IOException {

        String inputName = customerLoginName.getText().trim();
        ArrayList<Customer> customers = loadCustomers();
        Customer foundCustomer = null;

        for (Customer c : customers) {
            if (c.getName().equalsIgnoreCase(inputName)) {
                foundCustomer = c;
                break;
            }
        }

        if (foundCustomer != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/nazah/CustomerDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Customer not found");
            errorAlert.show();
        }
    }
}