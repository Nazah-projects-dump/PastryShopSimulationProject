package team.nazah.cashier;

import team.nazah.customer.Order;

import java.io.Serializable;
import java.time.LocalDate;

public class Receipt implements Serializable {
    private String receiptId;
    private Order order;
    private double amount;
    private LocalDate date;
    private String promoCode;
    private static final long serialVersionUID = 1L;

    public Receipt() {
    }

    public Receipt(String receiptId, Order order, double amount, LocalDate date, String promoCode) {
        this.receiptId = receiptId;
        this.order = order;
        this.amount = amount;
        this.date = date;
        this.promoCode = promoCode;
    }

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptId='" + receiptId + '\'' +
                ", order=" + order +
                ", amount=" + amount +
                ", date=" + date +
                ", promoCode='" + promoCode + '\'' +
                '}';
    }

    public String generateReceipt() {

        String promoText;

        if (promoCode == null) {
            promoText = "NONE";
        } else {
            promoText = promoCode;
        }

        return "Receipt ID: " + receiptId +
                "\nOrder ID: " + order.getOrderId() +
                "\nAmount: " + amount +
                "\nPromo Code: " + promoText +
                "\nDate: " + date;
    }

    public void printReceipt() {
        System.out.println(generateReceipt());
    }
}
