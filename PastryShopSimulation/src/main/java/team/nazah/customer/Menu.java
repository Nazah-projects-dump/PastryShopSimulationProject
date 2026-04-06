package team.nazah.customer;

import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuItem> menuItems;

    public Menu() {
    }

    public Menu(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuItems=" + menuItems +
                '}';
    }
}
