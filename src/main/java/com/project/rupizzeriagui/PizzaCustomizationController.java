package com.project.rupizzeriagui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

    private MainMenuController mainMenuController;
    private ArrayList<Topping> defaultToppings;
    private Pizza pizza;
    private Image pizzaImg;
    private Order currentOrder;
    public void setMainMenuController(MainMenuController controller) {
        mainMenuController = controller;
        pizza = mainMenuController.getSelectedPizza();
        pizzaImg = mainMenuController.getSelectedPizzaImg();
        defaultToppings = pizza.getToppings();
        populateFields();
    }

    private void populateFields() {
        currentOrder = mainMenuController.getSelectedOrder();
        pizzaView.setImage(pizzaImg);
        imageButton.setText("Deluxe");
//        System.out.println("From PizzaViewController" + pizza.toString());
        ObservableList<String> sizes = FXCollections.observableArrayList(
                "small", "medium", "large");
        pizzaSize.setItems(sizes);
        pizzaSize.setValue("small");
        ObservableList<Topping> toppings =
                FXCollections.observableArrayList(Topping.Sausage,
                        Topping.Chicken, Topping.Beef, Topping.Ham,
                        Topping.Pineapple, Topping.BlackOlives,
                        Topping.Cheese, Topping.GreenPepper, Topping.Onion,
                        Topping.Pepperoni, Topping.Mushroom);
        additionalToppings.setItems(toppings);
//        ArrayList<Topping> defaultToppings = pizza.getToppings();
        toppings.removeAll(defaultToppings);
//        selectedToppings.setItems(FXCollections.observableList(defaultToppings));
        for (Topping defaultTopping : defaultToppings) {
            selectedToppings.getItems().add(defaultTopping);
        }
    }

    @FXML
    void onAddToOrderClick(ActionEvent event) {
        currentOrder.addPizza(pizza);
    }

    @FXML
    void onAddButtonClick(ActionEvent event) {
        Topping toppingToAdd =
                additionalToppings.getSelectionModel().getSelectedItem();
        if (toppingToAdd != null && pizza.addTopping(toppingToAdd)) {
            additionalToppings.getItems().remove(toppingToAdd);
            selectedToppings.getItems().add(toppingToAdd);
        }
    }

    @FXML
    void onRemoveButtonClick(ActionEvent event) {
        Topping toppingToRemove =
                selectedToppings.getSelectionModel().getSelectedItem();
        System.out.println(defaultToppings.toString());
        if (toppingToRemove != null && !defaultToppings.contains(toppingToRemove)) {
            selectedToppings.getItems().remove(toppingToRemove);
            additionalToppings.getItems().add(toppingToRemove);
            pizza.removeTopping(toppingToRemove);
        }
    }

}