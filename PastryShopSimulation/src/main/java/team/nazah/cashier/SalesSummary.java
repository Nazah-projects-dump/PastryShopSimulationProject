package team.nazah.cashier;

import team.nazah.customer.Order;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class SalesSummary implements Serializable {
    private LocalDate date;
    private double totalSales;
    private ArrayList<Order> orders;
    private static final long serialVersionUID = 1L;

    public SalesSummary() {
    }

    public SalesSummary(LocalDate date, double totalSales, ArrayList<Order> orders) {
        this.date = date;
        this.totalSales = totalSales;
        this.orders = orders;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "SalesSummary{" +
                "date=" + date +
                ", totalSales=" + totalSales +
                ", orders=" + orders +
                '}';
    }

    public String generateReport() {
        return "Date: " + date +
                "\nTotal Sales: " + totalSales +
                "\nOrders: " + orders.size();
    }
}
