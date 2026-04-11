package team.nazah.cashier;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import team.nazah.customer.Order;
import team.nazah.customer.OrderStatus;

import java.io.IOException;
import java.util.ArrayList;

public class CashierDashboardController
{
    @javafx.fxml.FXML
    private Label dashboardTestLabel;
    @javafx.fxml.FXML
    private TableView<Order> cancellationReqsTable;
    @javafx.fxml.FXML
    private TableView<Order> incomingOrdersTable;
    @javafx.fxml.FXML
    private TableColumn<Order,String> incomingOrdersColumn;
    @javafx.fxml.FXML
    private TableColumn<Order,String> cancellationReqsColumn;
    @javafx.fxml.FXML
    private TableColumn<Order,String> incomingOrdersStatusColumn;
    @javafx.fxml.FXML
    private TextField orderIdFilterTextField;
    @javafx.fxml.FXML
    private ComboBox<String> orderStatusFilterComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        incomingOrdersColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getOrderId()));
        incomingOrdersStatusColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStatus().toString()));
        cancellationReqsColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getOrderId()));
    }

    private Cashier currentCashier;

    public void receiveData(Cashier cashier) {
        this.currentCashier = cashier;
        loadTables();
    }

    private void loadTables() {

        ArrayList<Order> allOrders = Order.loadOrders();

        if (allOrders.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("No orders exist yet.");
            alert.show();

            incomingOrdersTable.getItems().clear();
            cancellationReqsTable.getItems().clear();
            return;
        }

        ArrayList<Order> incomingList = new ArrayList<>();
        ArrayList<Order> cancelList = new ArrayList<>();

        for (Order o : allOrders) {
            if (o.getStatus() == OrderStatus.PENDING ||
                    o.getStatus() == OrderStatus.CONFIRMED ||
                    o.getStatus() == OrderStatus.PAID) {
                incomingList.add(o);
            }

            if (o.getStatus() == OrderStatus.CANCEL_REQUESTED) {
                cancelList.add(o);
            }
        }

        incomingOrdersTable.getItems().clear();
        incomingOrdersTable.getItems().addAll(incomingList);
        cancellationReqsTable.getItems().clear();
        cancellationReqsTable.getItems().addAll(cancelList);
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
    public void viewSalesSummaryButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void resetFiltersButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ApplyFiltersButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void openCancellationReqButtonOnAction(ActionEvent actionEvent) throws IOException {

        Order selectedOrder = cancellationReqsTable.getSelectionModel().getSelectedItem();

        if (selectedOrder == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select a cancellation request.");
            alert.show();
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/nazah/CancellationRequestDetails.fxml"));
        Scene scene = new Scene(loader.load());

        CancellationRequestDetailsController controller = loader.getController();
        controller.receiveOrder(selectedOrder);
        controller.receiveCashier(currentCashier);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void openIncomingOrderButtonOnAction(ActionEvent actionEvent) throws IOException {

        Order selectedOrder = incomingOrdersTable.getSelectionModel().getSelectedItem();

        if (selectedOrder == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select an order.");
            alert.show();
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/nazah/IncomingOrderDetails.fxml"));
        Scene scene = new Scene(loader.load());

        IncomingOrderDetailsController controller = loader.getController();
        controller.receiveOrder(selectedOrder);
        controller.receiveCashier(currentCashier);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}