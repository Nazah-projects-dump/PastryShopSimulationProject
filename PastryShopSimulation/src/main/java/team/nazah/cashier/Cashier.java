package team.nazah.cashier;

import common.Employee;
import common.User;

public class Cashier extends User implements Employee {

    @Override
    public String getEmployeeId() {
        return "";
    }

    @Override
    public String getBranch() {
        return "";
    }

    @Override
    public void showDashboard() {

    }

    @Override
    public boolean login(String name, String password) {
        return false;
    }
}
