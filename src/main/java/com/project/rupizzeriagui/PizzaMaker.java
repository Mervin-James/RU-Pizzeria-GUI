package com.project.rupizzeriagui;

public class PizzaMaker {
    public static Pizza createPizza(String flavor) {
        return switch (flavor) {
            case "Hawaiian" -> new Hawaiian();
            case "Deluxe" -> new Deluxe();
            default -> new Pepperoni();
        };
    }
}
