package com.project.rupizzeriagui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(Main.class.getResource(
                        "main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 800);
        stage.setTitle("RU Pizzeria");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

////    FOR TESTING ONLY
//    public static void main(String[] args) throws FileNotFoundException {
//        StoreOrders SO = new StoreOrders();
//
//        Order order1 = new Order("1234567890");
//        Pizza p1 = PizzaMaker.createPizza("Deluxe");
//        p1.setSize(Size.medium);
//        p1.addTopping(Topping.BlackOlives);
//        order1.addPizza(p1);
//        Pizza p2 = PizzaMaker.createPizza("Pepperoni");
//        order1.addPizza(p2);
//
//        Order order2 = new Order("09876543212");
//        Pizza p3 = PizzaMaker.createPizza("Hawaiian");
//        p3.setSize(Size.large);
//        p3.addTopping(Topping.Chicken);
//        order2.addPizza(p3);
//
//        SO.addOrder(order1);
//        SO.addOrder(order2);
//        SO.export();
//    }
}