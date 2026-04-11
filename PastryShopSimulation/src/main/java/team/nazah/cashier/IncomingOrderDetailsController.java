package team.nazah.cashier;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import team.nazah.customer.Order;

import java.io.IOException;

public class IncomingOrderDetailsController
{
    @javafx.fxml.FXML
    private Label orderDetailsLabel;
    @javafx.fxml.FXML
    private ComboBox updateOrderStatusComboBox;
    @javafx.fxml.FXML
    private TextField promoCodeTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    private Order order;
    private Cashier cashier;

    public void receiveOrder(Order order) {
        this.order = order;
    }

    public void receiveCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    @javafx.fxml.FXML
    public void finalizeOrderButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/nazah/CashierDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void issueReceiptButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addPromoCodeButtonOnAction(ActionEvent actionEvent) {
    }
}