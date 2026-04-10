package team.nazah.customer;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {
    private String cartId;
    private ArrayList<CartItem> items;
    private double total;

    public Cart() {

    }

    public Cart(String cartId, ArrayList<CartItem> items, double total) {
        this.cartId = cartId;
        this.items = items;
        this.total = total;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<CartItem> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", items=" + items +
                ", total=" + total +
                '}';
    }

    public void calculateTotal() {
        total = 0;
        for (CartItem ci : items) {
            total += ci.getSubTotal();
        }
    }

    public void clearCart() {
        items.clear();
        total = 0;
    }

    public void addItem(MenuItem menuItem, int quantity) {

        for (CartItem ci : items) {
            if (ci.getItem().getItemId().equals(menuItem.getItemId())) {
                ci.setQuantity(ci.getQuantity() + quantity);
                calculateTotal();
                return;
            }
        }

        items.add(new CartItem(menuItem, quantity));
        calculateTotal();
    }

    public void removeItem(MenuItem menuItem) {

        for (int i = 0; i < items.size(); i++) {
            CartItem ci = items.get(i);

            if (ci.getItem().getItemId().equals(menuItem.getItemId())) {
                items.remove(i);
                break;
            }
        }

        calculateTotal();
    }
}
