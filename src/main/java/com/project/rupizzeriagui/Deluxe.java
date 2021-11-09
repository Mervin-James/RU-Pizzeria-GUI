package com.project.rupizzeriagui;

public class Deluxe extends Pizza {
    private static final int MIN_TOPPINGS = 5;
    private static final double BASE_PRICE_DELUXE = 12.99;

    public Deluxe() {
        toppings.add(Topping.Pepperoni);
        toppings.add(Topping.Sausage);
        toppings.add(Topping.Mushroom);
        toppings.add(Topping.Onion);
        toppings.add(Topping.GreenPepper);
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

    @Override
    public String toString() {
        return "Deluxe" + super.toString();
    }


}
