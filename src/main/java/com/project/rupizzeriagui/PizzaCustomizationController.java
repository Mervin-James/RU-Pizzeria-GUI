package com.project.rupizzeriagui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PizzaCustomizationController {
    private Pizza pizza;
    private Image pizzaImg;
    private Order currentOrder;
    private ArrayList<Topping> defaultToppings;

    @FXML
    private Button addToOrder;

    @FXML
    private Button imageButton;

    @FXML
    private TextField pizzaPrice;

    @FXML
    private ComboBox<String> pizzaSize;

    @FXML
    private ImageView pizzaView;

    @FXML
    private ListView<Topping> selectedToppings;

    @FXML
    private ListView<Topping> additionalToppings;

    public void setMainMenuController(MainMenuController controller) {
        pizza = controller.getSelectedPizza();
        pizzaImg = controller.getSelectedPizzaImg();
        currentOrder = controller.getSelectedOrder();
        defaultToppings = new ArrayList<>();
        defaultToppings.addAll(pizza.getToppings());
        populateFields();
    }

    private void populateFields() {
        pizzaView.setImage(pizzaImg);
        imageButton.setText(pizza.toString().substring(0,
                pizza.toString().indexOf(' ')));
        ObservableList<String> sizes = FXCollections.observableArrayList(
                "small", "medium", "large");
        pizzaSize.setItems(sizes);
        pizzaSize.setValue("small");
        ObservableList<Topping> toppings =
                FXCollections.observableArrayList(Topping.Sausage,
                        Topping.Chicken,
                        Topping.Beef,
                        Topping.Ham,
                        Topping.Pineapple,
                        Topping.BlackOlives,
                        Topping.GreenPepper,
                        Topping.Onion,
                        Topping.Pepperoni,
                        Topping.Mushroom);
        additionalToppings.setItems(toppings);
        toppings.removeAll(defaultToppings);
        for (Topping defaultTopping : defaultToppings) {
            selectedToppings.getItems().add(defaultTopping);
        }
        DecimalFormat df = new DecimalFormat("###,##0.00");
        pizzaPrice.setText(String.valueOf(df.format(pizza.price())));
    }

    @FXML
    void onPizzaSizeChange(ActionEvent event) {
        String size = pizzaSize.getSelectionModel().getSelectedItem();
        switch (size) {
            case "small" -> pizza.setSize(Size.small);
            case "medium" -> pizza.setSize(Size.medium);
            case "large" -> pizza.setSize(Size.large);
        }
        DecimalFormat df = new DecimalFormat("###,##0.00");
        pizzaPrice.setText(String.valueOf(df.format(pizza.price())));
    }

    @FXML
    void onAddToOrderClick(ActionEvent event) {
        currentOrder.addPizza(pizza);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMATION");
        alert.setHeaderText("Order");
        alert.setContentText("Pizza added to the order!");
        alert.showAndWait();
        Stage stage = (Stage) addToOrder.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onAddButtonClick(ActionEvent event) {
        Topping toppingToAdd =
                additionalToppings.getSelectionModel().getSelectedItem();
        if (toppingToAdd != null) {
            boolean isToppingAdded = pizza.addTopping(toppingToAdd);
            if (toppingToAdd != null && isToppingAdded) {
                additionalToppings.getItems().remove(toppingToAdd);
                selectedToppings.getItems().add(toppingToAdd);
            } else if (!isToppingAdded) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Maximum number of toppings");
                alert.setContentText("At most 7 toppings!");
                alert.showAndWait();
            }
            DecimalFormat df = new DecimalFormat("###,##0.00");
            pizzaPrice.setText(String.valueOf(df.format(pizza.price())));
        }
    }

    @FXML
    void onRemoveButtonClick(ActionEvent event) {
        Topping toppingToRemove =
                selectedToppings.getSelectionModel().getSelectedItem();
        boolean isDefaultTopping = defaultToppings.contains(toppingToRemove);
        if (toppingToRemove != null && !isDefaultTopping) {
            selectedToppings.getItems().remove(toppingToRemove);
            additionalToppings.getItems().add(toppingToRemove);
            pizza.removeTopping(toppingToRemove);
        } else if (isDefaultTopping) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Removing toppings");
            alert.setContentText("You are removing the essential toppings!");
            alert.showAndWait();
        }
        DecimalFormat df = new DecimalFormat("###,##0.00");
        pizzaPrice.setText(String.valueOf(df.format(pizza.price())));
    }

}