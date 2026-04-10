package common;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import team.nazah.customer.Customer;
import team.nazah.customer.Menu;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Pastry Shop Simulation");
        stage.setScene(scene);
        stage.show();

       //Customer.createDummyCustomers();
        // Menu.createMenu();
    }
}


