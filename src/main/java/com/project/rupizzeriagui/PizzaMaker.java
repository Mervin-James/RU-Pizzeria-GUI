package com.project.rupizzeriagui;

public class PizzaMaker {
    public static Pizza createPizza(String flavor) {
        switch (flavor) {
            case "Pepperoni":
                return new Pepperoni();
            case "Hawaiian":
                return new Hawaiian();
            case "Deluxe":
                return new Deluxe();
            default:
                return new Pepperoni();
        }
    }
}
