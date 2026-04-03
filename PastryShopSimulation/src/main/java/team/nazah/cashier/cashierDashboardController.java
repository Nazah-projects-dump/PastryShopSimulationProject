package team.nazah.cashier;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class CashierDashboardController
{
    @javafx.fxml.FXML
    private Label dashboardTestLabel;
    @javafx.fxml.FXML
    private TableView cancellationReqsTable;
    @javafx.fxml.FXML
    private TableView incomingOrdersTable;
    @javafx.fxml.FXML
    private TableColumn incomingOrdersColumn;
    @javafx.fxml.FXML
    private TableColumn cancellationReqsOpenColumn;
    @javafx.fxml.FXML
    private TableColumn cancellationReqsColumn;
    @javafx.fxml.FXML
    private TableColumn incomingOrdersStatusColumn;
    @javafx.fxml.FXML
    private TableColumn incomingOrdersOpenColumn1;
    @javafx.fxml.FXML
    private TextField orderIdFilterTextField;
    @javafx.fxml.FXML
    private ComboBox orderStatusFilterComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void logoutButtonOnAction(ActionEvent actionEvent) {
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
}