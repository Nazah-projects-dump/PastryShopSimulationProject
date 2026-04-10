package team.nazah.customer;

import java.io.*;
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
            if (item.getCategory().equalsIgnoreCase(category)) {
                categorized.add(item);
            }
        }
        return categorized;
    }

    public ArrayList<MenuItem> applyFilters(ArrayList<MenuItem> list, Double minPrice, Double maxPrice, Boolean veganOnly) {
        ArrayList<MenuItem> filtered = new ArrayList<>();

        for (MenuItem item : list) {
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
        try {
            FileOutputStream fos = new FileOutputStream("Menu.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(menu);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Menu loadMenu() {
        Menu menu = null;

        try {
            FileInputStream fis = new FileInputStream("Menu.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            menu = (Menu) ois.readObject();
            ois.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return menu;
    }

    /*public static void createMenu() {
        Menu menu = new Menu();
        ArrayList<MenuItem> items = new ArrayList<>();

        // CAKES
        items.add(new MenuItem("C1", "Chocolate Cake", "Cakes", 15.0, 10, false, 0));
        items.add(new MenuItem("C2", "Vanilla Cake", "Cakes", 12.0, 8, false, 0));
        items.add(new MenuItem("C3", "Strawberry Cake", "Cakes", 14.0, 6, false, 0));
        items.add(new MenuItem("C4", "Dark Cocoa Cake", "Cakes", 16.0, 5, true, 0));
        items.add(new MenuItem("C5", "Lemon Cake", "Cakes", 13.0, 7, true, 0));

        // CUPCAKES
        items.add(new MenuItem("CC1", "Chocolate Cupcake", "Cupcakes", 4.0, 20, false, 0));
        items.add(new MenuItem("CC2", "Vanilla Cupcake", "Cupcakes", 3.5, 18, false, 0));
        items.add(new MenuItem("CC3", "Red Velvet Cupcake", "Cupcakes", 4.5, 15, false, 0));
        items.add(new MenuItem("CC4", "Cocoa Cupcake", "Cupcakes", 4.5, 12, true, 0));
        items.add(new MenuItem("CC5", "Fruit Cupcake", "Cupcakes", 4.0, 10, true, 0));

        // COOKIES
        items.add(new MenuItem("K1", "Chocolate Chip Cookie", "Cookies", 2.0, 30, false, 0));
        items.add(new MenuItem("K2", "Oatmeal Cookie", "Cookies", 2.5, 25, false, 0));
        items.add(new MenuItem("K3", "Peanut Butter Cookie", "Cookies", 2.5, 20, false, 0));
        items.add(new MenuItem("K4", "Dark Chocolate Cookie", "Cookies", 2.5, 18, true, 0));
        items.add(new MenuItem("K5", "Oat Crunch Cookie", "Cookies", 2.0, 22, true, 0));

        // DRINKS
        items.add(new MenuItem("D1", "Coffee", "Drinks", 3.0, 50, false, 0));
        items.add(new MenuItem("D2", "Hot Chocolate", "Drinks", 3.5, 40, false, 0));
        items.add(new MenuItem("D3", "Milkshake", "Drinks", 5.0, 20, false, 0));
        items.add(new MenuItem("D4", "Berry Smoothie", "Drinks", 4.5, 25, true, 0));
        items.add(new MenuItem("D5", "Fresh Juice", "Drinks", 4.0, 30, true, 0));

        menu.setMenuItems(items);

        saveMenu(menu);
    }*/
}
