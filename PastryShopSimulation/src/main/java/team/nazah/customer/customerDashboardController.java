package team.nazah.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerDashboardController
{
    private Customer currentCustomer;
    @javafx.fxml.FXML
    private Label dashboardTestLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    public void setCustomer(Customer customer) {
        this.currentCustomer = customer;
    }

    @javafx.fxml.FXML
    public void trackOrderButtonOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/nazah/TrackOrders.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }

    @javafx.fxml.FXML
    public void viewCartButtonOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/nazah/Cart.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }

    @javafx.fxml.FXML
    public void logoutButtonOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }

    @javafx.fxml.FXML
    public void feedbackButtonOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/nazah/Feedback.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        FeedbackController feedbackController = fxmlLoader.getController();
        feedbackController.receiveData(currentCustomer);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }

    @javafx.fxml.FXML
    public void viewMenuButtonOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/nazah/Menu.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }
}