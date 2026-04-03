package team.nazah.customer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

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
    public void viewCartFromMenuButtonOnAction(ActionEvent actionEvent) {
    }
}