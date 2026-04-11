package team.nazah.customer;

import common.AppendableObjectOutputStream;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Order implements Serializable {
    private String orderId;
    private ArrayList<CartItem> items;
    private double totalAmount;
    private OrderStatus status;
    private LocalDate date;
    private Customer customer;
    private static final long serialVersionUID = 1L;

    public Order() {
    }

    public Order(String orderId, ArrayList<CartItem> items, double totalAmount, OrderStatus status, LocalDate date, Customer customer) {
        this.orderId = orderId;
        this.items = items;
        this.totalAmount = totalAmount;
        this.status = status;
        this.date = date;
        this.customer = customer;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<CartItem> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", items=" + items +
                ", totalAmount=" + totalAmount +
                ", status=" + status +
                ", date=" + date +
                ", customer=" + customer +
                '}';
    }

    public double calculateTotal() {
        double total = 0;

        for (CartItem item : items) {
            total += item.getSubTotal();
        }

        this.totalAmount = total;
        return total;
    }

    public void updateStatus(OrderStatus status) {
        this.status = status;
    }

    public boolean isCancelable() {
        if (status == OrderStatus.PENDING || status == OrderStatus.CONFIRMED || status == OrderStatus.PAID){
            return true;
        }else{
            return false;
        }
    }

    public OrderStatus getOrderStatus() {
        return status;
    }

    public static String generateOrderID() {
        Random r = new Random();
        String randomOrderId = String.format("%06d",r.nextInt(1000000));
        return "ORD-" + randomOrderId;
    }

    public static void saveOrder(Order order) {
        try {

            File f = new File("Order.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(order);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Order> loadOrders() {
        ArrayList<Order> orders = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("Order.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                Order order = (Order) ois.readObject();
                orders.add(order);
            }

        } catch (EOFException e) {
            //
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }
}
