module pastryshopsimulation {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    exports common;
    opens common to javafx.fxml,javafx.base;

    opens team.nazah.customer to javafx.fxml,javafx.base;
    opens team.nazah.cashier to javafx.fxml,javafx.base;
    exports team.nazah.customer;
    exports team.nazah.cashier;

    opens team.leyana.baker to javafx.fxml,javafx.base;
    opens team.leyana.inventorymanager to javafx.fxml,javafx.base;

    opens team.afsana.branchmanager to javafx.fxml,javafx.base;
    opens team.afsana.supplier to javafx.fxml,javafx.base;
}


