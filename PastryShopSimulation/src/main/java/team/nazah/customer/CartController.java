package team.nazah.customer;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController
{
    private Cart cart = Cart.loadCart();
    @javafx.fxml.FXML
    private TableColumn<CartItem, Integer> cartQuantityColumn;
    @javafx.fxml.FXML
    private TableView<CartItem> cartTableView;
    @javafx.fxml.FXML
    private TableColumn<CartItem,String> cartItemColumn;
    @javafx.fxml.FXML
    private TableColumn<CartItem,Double> cartItemSubtotalColumn;
    @javafx.fxml.FXML
    private TableColumn<CartItem,Double> cartPriceColumn;
    @javafx.fxml.FXML
    private Label cartTotalLabel;

    @javafx.fxml.FXML
    public void initialize() {
        cartQuantityColumn.setCellValueFactory(new PropertyValueFactory<CartItem,Integer>("quantity"));
        cartItemSubtotalColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getSubTotal()).asObject());
        cartItemColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getItem().getName()));
        cartPriceColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getItem().getPrice()).asObject());
    }

    @javafx.fxml.FXML
    public void placeOrderButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/nazah/CustomerDashboard.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }

    @javafx.fxml.FXML
    public void removeItemButtonOnAction(ActionEvent actionEvent) {
        CartItem selectedItem = cartTableView.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            cart.removeItem(selectedItem);
            cartTableView.getItems().remove(selectedItem);
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("No item has been selected.");
            errorAlert.show();
        }
        cart.calculateTotal();
        cartTotalLabel.setText(String.valueOf(cart.getTotal()));
    }
}