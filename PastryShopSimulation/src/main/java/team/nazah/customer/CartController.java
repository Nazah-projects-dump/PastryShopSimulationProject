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
import java.time.LocalDate;
import java.util.ArrayList;

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

        cartTableView.getItems().addAll(cart.getItems());
        cartTotalLabel.setText("Total: " + String.valueOf(cart.getTotal()));
    }

    private Customer currentCustomer;
    public void receiveData(Customer customer) {
        this.currentCustomer = customer;
    }

    @javafx.fxml.FXML
    public void placeOrderButtonOnAction(ActionEvent actionEvent) throws IOException {

        if (cart.getItems().isEmpty()) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Your cart is empty.");
            errorAlert.show();
            return;
        }

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm Order");
        confirmAlert.setHeaderText("Order Summary");
        confirmAlert.setContentText("Do you want to place this order?");

        if (confirmAlert.showAndWait().get() == ButtonType.OK) {

            Order order = new Order(
                    Order.generateOrderID(),
                    new ArrayList<>(cart.getItems()),
                    cart.getTotal(),
                    OrderStatus.PENDING,
                    LocalDate.now(),
                    currentCustomer
            );

            order.updateStatus(OrderStatus.CONFIRMED);
            Order.saveOrder(order);

            cart.clearCart();
            Cart.saveCart(cart);

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setContentText("Order placed successfully!\nOrder ID: " + order.getOrderId());
            successAlert.show();


            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/nazah/PaymentScreen.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            PaymentScreenController controller = fxmlLoader.getController();
            controller.receiveOrder(order);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
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
        cartTotalLabel.setText("Total: " + String.valueOf(cart.getTotal()));
    }

    @javafx.fxml.FXML
    public void backToMenuButtonOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/nazah/Menu.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/nazah/CustomerDashboard.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }
}