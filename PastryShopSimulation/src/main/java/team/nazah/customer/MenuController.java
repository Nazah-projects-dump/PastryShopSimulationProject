package team.nazah.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MenuController
{
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
        menuCategoryComboBox.getItems().addAll("Cakes", "Cupcakes" ,"Cookies","Drinks");
        menuItemColumn.setCellValueFactory(new PropertyValueFactory<MenuItem,String>("name"));
        menuPriceColumn.setCellValueFactory(new PropertyValueFactory<MenuItem,Double>("price"));
        menuCategoryColumn.setCellValueFactory(new PropertyValueFactory<MenuItem,String>("category"));
        menuVeganColumn.setCellValueFactory(new PropertyValueFactory<MenuItem,Boolean>("Vegan"));
        menuAddToCartColumn.setCellFactory(col -> new TableCell<>() {

            private final Button button = new Button("Add");

            {
                button.setOnAction(event -> {
                    MenuItem item = getTableView().getItems().get(getIndex());
                    // Popup logic
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(button);
                }
            }
        });

        Menu menu = Menu.loadMenu();

        if (menu != null) {
            menuTableView.getItems().addAll(menu.getMenuItems());
        }
    }

    @javafx.fxml.FXML
    public void applyFiltersButtonOnAction(ActionEvent actionEvent) {
        Menu menu = Menu.loadMenu();

        Double minPrice = null;
        Double maxPrice = null;
        Boolean veganOnly = null;
        String category = null;

        try {
            if (!menuMinPriceFilterTextField.getText().isEmpty()) {
                minPrice = Double.parseDouble(menuMinPriceFilterTextField.getText());
            }

            if (!menuMaxPriceFilterTextField.getText().isEmpty()) {
                maxPrice = Double.parseDouble(menuMaxPriceFilterTextField.getText());
            }
        } catch (NumberFormatException e) {
            filterStatusLabel.setText("Invalid price input");
            return;
        }

        if (veganCheckBox.isSelected()) {
            veganOnly = true;
        }

        if (menuCategoryComboBox.getValue() != null) {
            category = menuCategoryComboBox.getValue();
        }

        ArrayList<MenuItem> filteredList;

        if (category != null && !category.isEmpty()) {
            ArrayList<MenuItem> categoryList = menu.getItemsByCategory(category);
            filteredList = menu.applyFilters(categoryList, minPrice, maxPrice, veganOnly);
        } else {
            filteredList = menu.applyFilters(minPrice, maxPrice, veganOnly);
        }

        menuTableView.getItems().clear();
        menuTableView.getItems().addAll(filteredList);

        filterStatusLabel.setText("Filters applied");
    }

    @javafx.fxml.FXML
    public void resetFiltersButtonOnAction(ActionEvent actionEvent) {
        Menu menu = Menu.loadMenu();
        menuTableView.getItems().clear();
        menuTableView.getItems().addAll(menu.getMenuItems());
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