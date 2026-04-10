package team.nazah.customer;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;

public class Cart implements Serializable {
    private String cartId;
    private ArrayList<CartItem> items;
    private double total;
    private static final long serialVersionUID = 1L;

    public Cart() {
        items = new ArrayList<>();
        total = 0.0;
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

    public boolean addItem(MenuItem menuItem, int quantity) {

        if (quantity > menuItem.getAvailableStock()) {
            return false;
        }

        for (CartItem ci : items) {
            if (ci.getItem().getItemId().equals(menuItem.getItemId())) {
                int newQuantity = ci.getQuantity() + quantity;

                if (newQuantity > menuItem.getAvailableStock()) {
                    return false;
                }

                ci.setQuantity(newQuantity);
                calculateTotal();
                saveCart(this);
                return true;
            }
        }

        items.add(new CartItem(menuItem, quantity));
        calculateTotal();
        saveCart(this);
        return true;
    }

    public void removeItem(CartItem item) {
        items.remove(item);
        calculateTotal();
        saveCart(this);
    }

    public static void saveCart(Cart cart) {
        try {
            FileOutputStream fos = new FileOutputStream("Cart.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(cart);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Cart loadCart() {
        Cart cart = null;

        try {
            FileInputStream fis = new FileInputStream("Cart.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            cart = (Cart) ois.readObject();
            ois.close();

        } catch (Exception e) {
            cart = new Cart();
        }

        return cart;
    }
}
