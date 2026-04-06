package team.nazah.customer;

import common.User;

import java.util.ArrayList;

public class Customer extends User {
    private Cart cart;
    private ArrayList<Order> orders;

    public Customer() {
    }

    public Customer(String userId, String name, Cart cart, ArrayList<Order> orders) {
        super(userId, name);
        this.cart = cart;
        this.orders = orders;
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

    }

    @Override
    public boolean login(String name, String password) {
        return this.name.equals(name);
    }


}
