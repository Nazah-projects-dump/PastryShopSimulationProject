package team.nazah.cashier;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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