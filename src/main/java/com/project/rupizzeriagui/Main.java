package com.project.rupizzeriagui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A class that creates a scene and launches the project's Main Menu GUI.
 *
 * @author Mervin James, Akshar Patel
 */
public class Main extends Application {
    /**
     * Method that creates the scene for the project's Main Menu GUI.
     *
     * @param stage object that represents the primary window of the JavaFX
     *              application.
     * @throws IOException exception caused by an input/output error.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(Main.class.getResource(
                        "main-menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 800);
        stage.setTitle("RU Pizzeria");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method that launches the project GUI.
     *
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        launch();
    }
}