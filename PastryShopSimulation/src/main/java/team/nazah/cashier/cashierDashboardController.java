package team.nazah.cashier;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

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

    private Cashier currentCashier;

    public void receiveData(Cashier cashier) {
        this.currentCashier = cashier;
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
}