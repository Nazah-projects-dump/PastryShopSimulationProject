module pastryshopsimulation {
    requires javafx.controls;
    requires javafx.fxml;

    exports common;
    opens common to javafx.fxml;
}


