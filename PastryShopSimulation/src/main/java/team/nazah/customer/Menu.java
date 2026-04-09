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

    public MenuItem getItem(String itemId) {
        for (MenuItem item : menuItems) {
            if (item.getItemId().equals(itemId))
                return item;
        }
        return null;
    }

    public ArrayList<MenuItem> getItemsByCategory(String category) {
        ArrayList<MenuItem> categorized = new ArrayList<>();
        for (MenuItem item : menuItems) {
            if (item.getCategory().equals(category)) {
                categorized.add(item);
            }
        }
        return categorized;
    }

    public ArrayList<MenuItem> applyFilters(Double minPrice, Double maxPrice, Boolean veganOnly) {
        ArrayList<MenuItem> filtered = new ArrayList<>();

        for (MenuItem item : menuItems) {
            boolean passes = true;

            if (minPrice != null && item.getPrice() < minPrice) {
                passes = false;
            }
            if (maxPrice != null && item.getPrice() > maxPrice) {
                passes = false;
            }
            if (veganOnly != null && veganOnly && !item.isVegan()) {
                passes = false;
            }

            if (passes) {
                filtered.add(item);
            }
        }
        return filtered;
    }

    public static void saveMenu(Menu menu) {

    }
    public static Menu loadMenu() {
        Menu menu = null;
        return menu;
    }
}
