package com.project.rupizzeriagui;

public class Pepperoni extends Pizza{
    private static final int MIN_TOPPINGS = 1;
    private static final double BASE_PRICE_DELUXE = 8.99;

    public Pepperoni() {
        toppings.add(Topping.Pepperoni);
        size = Size.small;
    }

    @Override
    public double price() {
        double sizeCost = 0.0;
        if (size == Size.medium) {
            sizeCost = ADDITIONAL_PRICE_MEDIUM_SIZE;
        } else if (size == Size.large) {
            sizeCost = ADDITIONAL_PRICE_LARGE_SIZE;
        }
        return (toppings.size() - MIN_TOPPINGS) * PRICE_PER_TOPPING +
                sizeCost + BASE_PRICE_DELUXE;
    }
}
