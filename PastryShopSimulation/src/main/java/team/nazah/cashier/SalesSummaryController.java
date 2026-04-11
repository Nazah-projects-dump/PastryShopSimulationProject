package team.nazah.cashier;

import javafx.beans.property.SimpleDoubleProperty;
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
import java.time.LocalDate;
import java.util.ArrayList;

public class SalesSummaryController
{
    @javafx.fxml.FXML
    private TableView<Order> salesSummaryTableView;
    @javafx.fxml.FXML
    private TableColumn<Order,String> orderIdColumn;
    @javafx.fxml.FXML
    private TableColumn<Order,Double> totalColumn;
    @javafx.fxml.FXML
    private DatePicker salesSummaryDatePicker;
    @javafx.fxml.FXML
    private Label showReportLabel;

    @javafx.fxml.FXML
    public void initialize() {
        orderIdColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getOrderId()));
        totalColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getTotalAmount()).asObject());
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
    public void generateReportButtonOnAction(ActionEvent actionEvent) {
        LocalDate selectedDate = salesSummaryDatePicker.getValue();

        if (selectedDate == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select a date.");
            alert.show();
            return;
        }

        ArrayList<Order> allOrders = Order.loadOrders();
        ArrayList<Order> filtered = new ArrayList<>();

        double totalSales = 0;

        for (Order o : allOrders) {
            if (o.getDate().equals(selectedDate)) {

                if (o.getStatus() == OrderStatus.CANCELLED) {
                    continue;
                }

                filtered.add(o);
                totalSales += o.getTotalAmount();
            }
        }

        salesSummaryTableView.getItems().clear();
        salesSummaryTableView.getItems().addAll(filtered);

        showReportLabel.setText("Total Orders: " + filtered.size() + "\nTotal Sales: " + totalSales);
    }
}