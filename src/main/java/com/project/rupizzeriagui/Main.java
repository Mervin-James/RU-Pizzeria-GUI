package com.project.rupizzeriagui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(Main.class.getResource(
                        "main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    //FOR TESTING ONLY
//    public static void main(String[] args) {
//        Pizza p = PizzaMaker.createPizza("Deluxe");
//        System.out.println("before:" + p.price());
//        System.out.println(p.toString());
//        p.setSize(Size.medium);
//        p.addTopping(Topping.BlackOlives);
//        System.out.println("after:"+ p.price());
//        System.out.println(p.toString());
//    }
}