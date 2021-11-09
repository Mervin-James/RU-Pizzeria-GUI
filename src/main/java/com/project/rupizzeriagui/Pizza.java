package com.project.rupizzeriagui;

import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class Pizza {
    protected static final double ADDITIONAL_PRICE_MEDIUM_SIZE = 2.00;
    protected static final double ADDITIONAL_PRICE_LARGE_SIZE = 4.00;
    protected static final int MAX_TOPPINGS = 7;
    protected static final double PRICE_PER_TOPPING = 1.49;
    protected ArrayList<Topping> toppings = new ArrayList<Topping>();
    protected Size size;

    public abstract double price();

    public boolean addTopping(Topping topping) {
        if (toppings.size() < MAX_TOPPINGS) {
            return toppings.add(topping);
        }
        return false;
    }

    public boolean removeTopping(Topping topping) {
        return toppings.remove(topping);
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return this.size;
    }

    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###,##0.00");
        //removes leading and trailing brackets
        String toppingsListed = toppings.toString()
                .substring(1, toppings.toString().length() - 1);
        return " pizza, " + toppingsListed + ", " + size + ", " + "$" +
                df.format(price());
    }

}
