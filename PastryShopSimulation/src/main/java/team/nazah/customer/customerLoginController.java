package team.nazah.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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

        Customer test = new Customer("368","Madara");

        if (test.login(customerLoginName.getText(),null)){

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/nazah/CustomerDashboard.fxml"));

            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.show();
        }
    }
}