package team.nazah.cashier;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import team.nazah.customer.Order;
import team.nazah.customer.OrderStatus;

import java.io.IOException;

public class CancellationRequestDetailsController
{
    @javafx.fxml.FXML
    private Label refundAmountLabel;
    @javafx.fxml.FXML
    private TextField reasonTextField;
    @javafx.fxml.FXML
    private Label orderDetailslabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    private Order order;
    private Cashier cashier;
    public void receiveOrder(Order order) {
        this.order = order;
        orderDetailslabel.setText(
                "Order ID: " + order.getOrderId() +
                        "\nStatus: " + order.getStatus() +
                        "\nTotal: " + order.getTotalAmount()
        );

        refundAmountLabel.setText("Refund Amount: " + order.getTotalAmount());
    }
    public void receiveCashier(Cashier cashier) {
        this.cashier = cashier;
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
    public void confirmButtonOnAction(ActionEvent actionEvent) {
        order.updateStatus(OrderStatus.CANCELLED);

        Order.saveOrder(order);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Cancellation approved and refund processed.");
        alert.show();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/nazah/CashierDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}