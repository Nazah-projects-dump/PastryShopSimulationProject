package team.nazah.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController
{
    @javafx.fxml.FXML
    private TableColumn<MenuItem,Integer> menuQuantityColumn;
    @javafx.fxml.FXML
    private TextField menuMinPriceFilterTextField;
    @javafx.fxml.FXML
    private ComboBox<String> menuCategoryComboBox;
    @javafx.fxml.FXML
    private TableView<MenuItem> menuTableView;
    @javafx.fxml.FXML
    private TableColumn<MenuItem,Double> menuPriceColumn;
    @javafx.fxml.FXML
    private CheckBox veganCheckBox;
    @javafx.fxml.FXML
    private TableColumn<MenuItem,String> menuItemColumn;
    @javafx.fxml.FXML
    private TextField menuMaxPriceFilterTextField;
    @javafx.fxml.FXML
    private TableColumn<MenuItem,Void> menuAddToCartColumn;
    @javafx.fxml.FXML
    private Label filterStatusLabel;
    @javafx.fxml.FXML
    private TableColumn<MenuItem,String> menuCategoryColumn;
    @javafx.fxml.FXML
    private TableColumn<MenuItem,Boolean> menuVeganColumn;

    @javafx.fxml.FXML
    public void initialize() {
        menuItemColumn.setCellValueFactory(new PropertyValueFactory<MenuItem,String>("name"));
        menuPriceColumn.setCellValueFactory(new PropertyValueFactory<MenuItem,Double>("price"));
        menuQuantityColumn.setCellValueFactory(new PropertyValueFactory<MenuItem,Integer>("quantity"));
        menuCategoryColumn.setCellValueFactory(new PropertyValueFactory<MenuItem,String>("category"));
        menuVeganColumn.setCellValueFactory(new PropertyValueFactory<MenuItem,Boolean>("isVegan"));

    }

    @javafx.fxml.FXML
    public void applyFiltersButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void resetFiltersButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewCartFromMenuButtonOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/nazah/Cart.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/nazah/CustomerDashboard.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }
}