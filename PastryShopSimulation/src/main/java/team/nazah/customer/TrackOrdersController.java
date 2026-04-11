package team.nazah.customer;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TrackOrdersController
{
    @javafx.fxml.FXML
    private Label orderDetailsLabel;
    @javafx.fxml.FXML
    private TableColumn<Order,String> orderIdColumn;
    @javafx.fxml.FXML
    private TableView<Order> prevOrdersTableView;
    @javafx.fxml.FXML
    private TableColumn<Order, LocalDate> dateColumn;

    @javafx.fxml.FXML
    public void initialize() {
        orderIdColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getOrderId()));
        dateColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDate()));
    }

    private Customer currentCustomer;

    public void receiveData(Customer customer) {
        this.currentCustomer = customer;

        loadOrders();
    }

    private void loadOrders() {
        ArrayList<Order> allOrders = Order.loadOrders();

        ArrayList<Order> customerOrders = new ArrayList<>();

        for (Order o : allOrders) {
            if (o.getCustomerName().equals(currentCustomer.getName())) {
                customerOrders.add(o);
            }
        }

        prevOrdersTableView.getItems().clear();
        prevOrdersTableView.getItems().addAll(customerOrders);
    }

    @javafx.fxml.FXML
    public void cancelOrderButtonOnAction(ActionEvent actionEvent) {
        Order selectedOrder = prevOrdersTableView.getSelectionModel().getSelectedItem();

        if (selectedOrder == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No order selected.");
            alert.show();
            return;
        }

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setContentText("Are you sure you want to cancel this order?");
        confirmAlert.showAndWait();

        if (confirmAlert.getResult() != ButtonType.OK) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please confirm cancellation to proceed.");
            alert.show();
            return;
        }

        if (!selectedOrder.isCancelable()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Order cannot be canceled at this stage.");
            alert.show();
            return;
        }

        selectedOrder.updateStatus(OrderStatus.CANCELLED);

        Order.saveOrder(selectedOrder);

        loadOrders();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Order cancelled successfully.");
        alert.show();
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/nazah/CustomerDashboard.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        CustomerDashboardController controller = fxmlLoader.getController();
        controller.setCustomer(currentCustomer);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }

    @javafx.fxml.FXML
    public void selectOrderButtonOnAction(ActionEvent actionEvent) {

        Order selectedOrder = prevOrdersTableView.getSelectionModel().getSelectedItem();

        if (selectedOrder == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select an order.");
            alert.show();
            return;
        }

        orderDetailsLabel.setText(
                "Order ID: " + selectedOrder.getOrderId() +
                        "\nDate: " + selectedOrder.getDate() +
                        "\nTotal: " + selectedOrder.getTotalAmount() +
                        "\nStatus: " + selectedOrder.getStatus()
        );
    }
}