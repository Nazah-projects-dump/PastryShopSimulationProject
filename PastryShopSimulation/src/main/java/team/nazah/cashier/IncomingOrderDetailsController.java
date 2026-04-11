package team.nazah.cashier;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import team.nazah.customer.Order;
import team.nazah.customer.OrderStatus;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

public class IncomingOrderDetailsController
{
    private String promoCode = null;
    private boolean receiptIssued = false;
    @javafx.fxml.FXML
    private Label orderDetailsLabel;
    @javafx.fxml.FXML
    private ComboBox<String> updateOrderStatusComboBox;
    @javafx.fxml.FXML
    private TextField promoCodeTextField;

    @javafx.fxml.FXML
    public void initialize() {
        updateOrderStatusComboBox.getItems().addAll("COMPLETED");
    }

    private Order order;
    private Cashier cashier;

    public void receiveOrder(Order order) {
        this.order = order;
        orderDetailsLabel.setText(
                "Order ID: " + order.getOrderId() +
                        "\nStatus: " + order.getStatus() +
                        "\nTotal: " + order.getTotalAmount()
        );
    }

    public void receiveCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    @javafx.fxml.FXML
    public void finalizeOrderButtonOnAction(ActionEvent actionEvent) throws IOException {
        if (order == null) return;

        if (updateOrderStatusComboBox.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Select COMPLETED status first.");
            alert.show();
            return;
        }

        if (!receiptIssued) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Issue receipt before finalizing.");
            alert.show();
            return;
        }

        order.updateStatus(OrderStatus.COMPLETED);
        Order.saveOrder(order);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/nazah/CashierDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
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
        if (order == null) return;

        String code;

        if (promoCode == null) {
            code = "NONE";
        } else {
            code = promoCode;
        }

        Random r = new Random();
        String receiptId = String.format("%06d",r.nextInt(1000000));

        Receipt receipt = new Receipt(
                receiptId,
                order,
                order.getTotalAmount(),
                LocalDate.now(),
                code
        );

        Receipt.saveReceipt(receipt);

        receiptIssued = true;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Receipt issued successfully.");
        alert.show();
    }

    @javafx.fxml.FXML
    public void addPromoCodeButtonOnAction(ActionEvent actionEvent) {
        String input = promoCodeTextField.getText().trim();

        if (input.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter a promo code.");
            alert.show();
            return;
        }

        promoCode = input;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Promo code added to receipt.");
        alert.show();
    }
}