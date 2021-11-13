package com.project.rupizzeriagui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class PizzaCustomizationController {

    @FXML
    private Button addToOrder;

    @FXML
    private Button addTopping;

    @FXML
    private Button imageButton;

    @FXML
    private TextField pizzaPrice;

    @FXML
    private ComboBox<String> pizzaSize;

    @FXML
    private ImageView pizzaView;

    @FXML
    private Button removeTopping;

    @FXML
    private ListView<String> selectedToppings;

    @FXML
    private ListView<String> additionalToppings;

    @FXML
    public void initialize() {
        ObservableList<String> items = FXCollections.observableArrayList(
                "small", "medium", "large");
        pizzaSize.setItems(items);
        pizzaSize.setValue("small");

        ObservableList<String> toppings =
                FXCollections.observableArrayList("Sausage", "Chicken",
                        "Beef", "Ham", "Pineapple", "BlackOlives", "Cheese"
                        , "GreenPepper", "Onion", "Pepperoni", "Mushroom");
        additionalToppings.setItems(toppings);
    }

    private MainMenuController mainMenuController;
    public void setMainMenuController(MainMenuController controller) {
        mainMenuController = controller;
    }

}