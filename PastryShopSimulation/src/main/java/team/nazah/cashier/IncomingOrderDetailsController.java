package team.nazah.cashier;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import team.nazah.customer.Order;

public class IncomingOrderDetailsController
{
    @javafx.fxml.FXML
    private Label orderDetailsLabel;
    @javafx.fxml.FXML
    private TextField paymentAmountTextField;
    @javafx.fxml.FXML
    private TextField discountTextField;
    @javafx.fxml.FXML
    private ComboBox updateOrderStatusComboBox;

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
    public void backButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void applyDiscountButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void issueReceiptButtonOnAction(ActionEvent actionEvent) {
    }
}