package team.nazah.customer;

import java.io.Serializable;
import java.util.ArrayList;

public class Menu implements Serializable {
    private ArrayList<MenuItem> menuItems;
    private static final long serialVersionUID = 1L;

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

    public static void saveMenu(Menu menu) {

    }
    public static Menu loadMenu() {
        Menu menu = null;
        return menu;
    }
}
