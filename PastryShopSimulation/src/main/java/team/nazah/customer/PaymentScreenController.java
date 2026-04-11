package team.nazah.customer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;

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
    private RadioButton paymentMethodCardRadioButton;
    @javafx.fxml.FXML
    private Label cardPinLabel;
    @javafx.fxml.FXML
    private Label cardNumberLabel;

    @javafx.fxml.FXML
    public void initialize() {
        cardNumberTextField.setVisible(false);
        cardPinTextField.setVisible(false);
        cardNumberLabel.setVisible(false);
        cardPinLabel.setVisible(false);

        ToggleGroup tg = new ToggleGroup();
        paymentMethodCardRadioButton.setToggleGroup(tg);
        paymentMethodCashRadioButton.setToggleGroup(tg);
    }

    private Order order;
    public void receiveOrder(Order order) {
        this.order = order;

        paymentScreenOrderIdLabel.setText(order.getOrderId());
        paymentScreenTotalLabel.setText(String.valueOf(order.getTotalAmount()));
    }

    public void paymentMethodOnAction(ActionEvent event) {

        boolean isCard = paymentMethodCardRadioButton.isSelected();
        cardNumberTextField.setVisible(isCard);
        cardPinTextField.setVisible(isCard);
        cardNumberLabel.setVisible(isCard);
        cardPinLabel.setVisible(isCard);
    }

    @javafx.fxml.FXML
    public void payNowButtonOnAction(ActionEvent actionEvent) {

        if (order == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No order found.");
            alert.show();
            return;
        }

        String paymentMethod;

        if (paymentMethodCardRadioButton.isSelected()) {
            paymentMethod = "CARD";
        } else if (paymentMethodCashRadioButton.isSelected()) {
            paymentMethod = "CASH";
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select a payment method.");
            alert.show();
            return;
        }

        if (paymentMethod.equals("CARD")) {

            String cardNumber = cardNumberTextField.getText();
            String cardPin = cardPinTextField.getText();

            if (cardNumber.isEmpty() || cardPin.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please fill in card details.");
                alert.show();
                return;
            }

            boolean valid = true;

            for (int i = 0; i < cardNumber.length(); i++) {
                if (cardNumber.charAt(i) < '0' || cardNumber.charAt(i) > '9') {
                    valid = false;
                    break;
                }
                if (cardPin.charAt(i) < '0' || cardPin.charAt(i) > '9') {
                    valid = false;
                    break;
                }
            }

            if (!valid) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Card details must be numeric.");
                alert.show();
                return;
            }
        }

        Payment payment = new Payment(
                Payment.generatePaymentId(),
                order,
                order.getTotalAmount(),
                paymentMethod,
                LocalDate.now()
        );

        boolean success = payment.processPayment(order.getTotalAmount());

        if (success) {

            payment.updateOrderStatus();

            Order.saveOrder(order);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Payment successful!");
            alert.show();

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Payment failed.");
            alert.show();
        }
    }

    @javafx.fxml.FXML
    public void cancelOrderButtonOnAction(ActionEvent actionEvent) {
        
    }
}