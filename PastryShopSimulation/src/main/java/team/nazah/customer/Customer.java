package team.nazah.customer;

import common.AppendableObjectOutputStream;
import common.User;
import java.io.*;
import java.util.ArrayList;

public class Customer extends User implements Serializable {
    private Cart cart;
    private ArrayList<Order> orders;
    private static final long serialVersionUID = 1L;

    public Customer() {
    }

    public Customer(String userId, String name) {
        super(userId, name);
        this.cart = new Cart();
        this.orders = new ArrayList<>();
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cart=" + cart +
                ", orders=" + orders +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void showDashboard() {
        //
    }

    @Override
    public boolean login(String name, String password) {
        return this.name.equals(name);
    }

    public ArrayList<MenuItem> browseMenu(Menu menu) {
        return menu.getMenuItems();
    }

    public ArrayList<MenuItem> filterMenu(Menu menu, Double min, Double max, Boolean vegan) {
        return menu.applyFilters(min, max, vegan);
    }

    public boolean addToCart(Cart cart, MenuItem item, int quantity) {
        return cart.addItem(item, quantity);
    }

    public void viewCart() {
        //
    }

    public void updateCart() {
        //
    }

    public void giveFeedback(Feedback feedback) {
        //
    }

    public static void saveCustomer(Customer customer) {
        try {
            File f = new File("Customer.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(customer);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Customer> loadCustomers() {
        ArrayList<Customer> list = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("Customer.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                Customer c = (Customer) ois.readObject();
                list.add(c);
            }
        } catch (EOFException e) {
            //
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    /*public static void createCustomers() {
        saveCustomer(new Customer("1", "John"));
        saveCustomer(new Customer("2", "Alice"));
        saveCustomer(new Customer("3", "Bob"));
    }*/
}
