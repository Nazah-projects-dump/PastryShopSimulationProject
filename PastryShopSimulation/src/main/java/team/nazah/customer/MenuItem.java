package team.nazah.customer;

import java.io.Serializable;
import java.util.ArrayList;

public class MenuItem implements Serializable {
    private String itemId;
    private String name;
    private String category;
    private double price;
    private int availableStock;
    private boolean isVegan;
    private int quantity;
    private static final long serialVersionUID = 1L;

    public MenuItem() {
    }

    public MenuItem(String itemId, String name, String category, double price, int availableStock, boolean isVegan, int quantity) {
        this.itemId = itemId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.availableStock = availableStock;
        this.isVegan = isVegan;
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "itemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", availableStock=" + availableStock +
                ", isVegan=" + isVegan +
                ", quantity=" + quantity +
                '}';
    }

    public boolean isAvailable(int quantity) {
        return availableStock >= quantity;
    }

    public void updateStock(int quantity) {
        if (quantity <= availableStock) {
            availableStock -= quantity;
        }
    }


}
