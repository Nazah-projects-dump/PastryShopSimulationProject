package team.nazah.customer;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CartController
{
    @javafx.fxml.FXML
    private TableColumn cartQuantityColumn;
    @javafx.fxml.FXML
    private TableView cartTableView;
    @javafx.fxml.FXML
    private TableColumn cartItemColumn;
    @javafx.fxml.FXML
    private TableColumn cartItemSubtotalColumn;
    @javafx.fxml.FXML
    private TableColumn cartPriceColumn;
    @javafx.fxml.FXML
    private Label cartTotalLabel;
    @javafx.fxml.FXML
    private TableColumn cartRemoveColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void placeOrderButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
    }
}