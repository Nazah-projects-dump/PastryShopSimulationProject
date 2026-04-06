package team.nazah.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController
{
    @javafx.fxml.FXML
    private TableColumn menuQuantityColumn;
    @javafx.fxml.FXML
    private TextField menuMinPriceFilterTextField;
    @javafx.fxml.FXML
    private ComboBox menuCategoryComboBox;
    @javafx.fxml.FXML
    private TableView menuTableView;
    @javafx.fxml.FXML
    private TableColumn menuPriceColumn;
    @javafx.fxml.FXML
    private CheckBox veganCheckBox;
    @javafx.fxml.FXML
    private TableColumn menuItemColumn;
    @javafx.fxml.FXML
    private TextField menuMaxPriceFilterTextField;
    @javafx.fxml.FXML
    private TableColumn menuAddToCartColumn;
    @javafx.fxml.FXML
    private Label filterStatusLabel;

    @javafx.fxml.FXML
    public void initialize() {
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