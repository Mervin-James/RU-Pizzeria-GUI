package com.project.rupizzeriagui;

public class Hawaiian extends Pizza {
    private static final int MIN_TOPPINGS = 2;
    private static final double BASE_PRICE_DELUXE = 10.99;

    public Hawaiian() {
        toppings.add(Topping.Pineapple);
        toppings.add(Topping.Ham);
        size = Size.small;
    }

    @Override public double price() {
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
