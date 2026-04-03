package team.nazah.cashier;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class cashierDashboardController
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
    private TableColumn incomingOrdersOpenColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void logoutButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewSalesSummaryButtonOnAction(ActionEvent actionEvent) {
    }
}