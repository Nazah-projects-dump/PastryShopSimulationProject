package team.nazah.customer;

import common.AppendableObjectOutputStream;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Payment implements Serializable {
    private String paymentId;
    private Order order;
    private double amount;
    private String paymentMethod;
    private LocalDate paymentDate;
    private static final long serialVersionUID = 1L;

    public Payment() {
    }

    public Payment(String paymentId, Order order, double amount, String paymentMethod, LocalDate paymentDate) {
        this.paymentId = paymentId;
        this.order = order;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", order=" + order +
                ", amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentDate=" + paymentDate +
                '}';
    }

    public static String generatePaymentId() {
        Random r = new Random();
        return String.format("%06d", r.nextInt(1000000));
    }

    public boolean processPayment(double amount) {
        if (amount <= 0) {
            return false;
        }

        return true;
    }

    public void updateOrderStatus() {
        order.updateStatus(OrderStatus.PAID);
    }

    public static void savePayment(Payment payment) {
        try {
            File f = new File("Payment.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(payment);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Payment> loadPayments() {
        ArrayList<Payment> payments = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("Payment.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    Payment p = (Payment) ois.readObject();
                    payments.add(p);
                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return payments;
    }
}
