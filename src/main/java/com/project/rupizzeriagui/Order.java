package com.project.rupizzeriagui;

import java.util.ArrayList;

public class Order {
    private static final double TAX_RATE = 0.06625;
    private final String phoneNumber;
    private final ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

    public Order(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    public ArrayList<Pizza> getPizzas() {
        return this.pizzas;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public double subtotal() {
        double subtotal = 0.0;
        for (int i = 0; i < pizzas.size(); i++) {
            subtotal += pizzas.get(i).price();
        }
        return subtotal;
    }

    public double salesTax() {
        return this.subtotal() * TAX_RATE;
    }

    public double orderTotal() {
        return this.subtotal() + this.salesTax();
    }
}
