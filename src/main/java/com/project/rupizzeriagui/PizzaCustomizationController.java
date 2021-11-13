package com.project.rupizzeriagui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

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
    private ListView<Topping> selectedToppings;

    @FXML
    private ListView<Topping> additionalToppings;

    @FXML
    public void initialize() {
//
//        if (pizza instanceof Deluxe) {
//            additionalToppings.getItems().remove(Topping.Pepperoni);
//            additionalToppings.getItems().remove(Topping.Sausage);
//            additionalToppings.getItems().remove(Topping.Mushroom);
//            additionalToppings.getItems().remove(Topping.Onion);
//            additionalToppings.getItems().remove(Topping.GreenPepper);
//            selectedToppings.getItems().add(Topping.Pepperoni);
//            selectedToppings.getItems().add(Topping.Sausage);
//            selectedToppings.getItems().add(Topping.Mushroom);
//            selectedToppings.getItems().add(Topping.Onion);
//            selectedToppings.getItems().add(Topping.GreenPepper);
//        }
    }

    private MainMenuController mainMenuController;
    private Pizza pizza;
    private Image pizzaImg;
    public void setMainMenuController(MainMenuController controller) {
        mainMenuController = controller;
        pizza = mainMenuController.getSelectedPizza();
        pizzaImg = mainMenuController.getSelectedPizzaImg();
        populateFields();
    }

    private void populateFields() {
        pizzaView.setImage(pizzaImg);
        imageButton.setText("Deluxe");
//        System.out.println("From PizzaViewController" + pizza.toString());
        ObservableList<String> items = FXCollections.observableArrayList(
                "small", "medium", "large");
        pizzaSize.setItems(items);
        pizzaSize.setValue("small");
        ObservableList<Topping> toppings =
                FXCollections.observableArrayList(Topping.Sausage,
                        Topping.Chicken, Topping.Beef, Topping.Ham,
                        Topping.Pineapple, Topping.BlackOlives,
                        Topping.Cheese, Topping.GreenPepper, Topping.Onion,
                        Topping.Pepperoni, Topping.Mushroom);
        additionalToppings.setItems(toppings);
        ArrayList<Topping> defaultToppings = pizza.getToppings();
        toppings.removeAll(defaultToppings);
        selectedToppings.setItems(FXCollections.observableList(defaultToppings));
    }



}