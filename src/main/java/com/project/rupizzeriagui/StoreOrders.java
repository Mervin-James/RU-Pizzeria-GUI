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

    public boolean addOrder(Order order) {
        return orders.add(order);
    }

    public boolean removeOrder(Order order) {
        return orders.remove(order);
    }

    public void export(File targetFile) throws FileNotFoundException {
        DecimalFormat df = new DecimalFormat("###,##0.00");
//        File file = new File("Store_Orders.txt");
//        if (file.exists()) {
//            //handle if file already exists (in case user might not want to
//            // overwrite existing Store_Orders file)
//        }
        PrintWriter pw = new PrintWriter(targetFile);
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
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
