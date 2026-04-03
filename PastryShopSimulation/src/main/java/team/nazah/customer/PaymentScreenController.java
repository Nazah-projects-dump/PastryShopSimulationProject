package team.nazah.customer;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class PaymentScreenController
{
    @javafx.fxml.FXML
    private RadioButton paymentMethodCashRadioButton;
    @javafx.fxml.FXML
    private Label paymentScreenOrderIdLabel;
    @javafx.fxml.FXML
    private TextField cardNumberTextField;
    @javafx.fxml.FXML
    private Label paymentScreenTotalLabel;
    @javafx.fxml.FXML
    private TextField cardPinTextField;
    @javafx.fxml.FXML
    private Label paymentStatusLabel;
    @javafx.fxml.FXML
    private RadioButton paymentMethodCardRadioButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void payNowButtonOnAction(ActionEvent actionEvent) {
    }
}