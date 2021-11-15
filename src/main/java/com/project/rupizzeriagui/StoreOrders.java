package com.project.rupizzeriagui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class StoreOrders {
    private final ArrayList<Order> orders;

    public StoreOrders() {
        this.orders = new ArrayList<Order>();
    }

    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public void export(File targetFile) throws FileNotFoundException {
        DecimalFormat df = new DecimalFormat("###,##0.00");
        PrintWriter pw = new PrintWriter(targetFile);
        for (Order order : orders) {
            pw.println("Customer phone number: " + order.getPhoneNumber());
            pw.println("\torders:");
            for (int j = 0; j < order.getPizzas().size(); j++) {
                Pizza pizza = order.getPizzas().get(j);
                pw.println("\t\t" + pizza.toString());
            }
            pw.println("\tsubtotal: $" + df.format(order.subtotal()));
            pw.println("\tsales tax: $" + df.format(order.salesTax()));
            pw.println("\torder total: $" + df.format(order.orderTotal()));
        }
        pw.close();
    }
}
