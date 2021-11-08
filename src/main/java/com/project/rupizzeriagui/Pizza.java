package com.project.rupizzeriagui;

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

}
