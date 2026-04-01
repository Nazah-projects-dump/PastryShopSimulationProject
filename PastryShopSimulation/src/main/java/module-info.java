module pastryshopsimulation {
    requires javafx.controls;
    requires javafx.fxml;

    exports common;
    opens common to javafx.fxml;
    opens team.nazah.customer to javafx.fxml;
    opens team.nazah.cashier to javafx.fxml;
    opens team.leyana.baker to javafx.fxml;
    opens team.leyana.inventorymanager to javafx.fxml;
    opens team.afsana.branchmanager to javafx.fxml;
    opens team.afsana.supplier to javafx.fxml;
}


