package com.project.rupizzeriagui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainMenuController {

    @FXML
    private Button currentOrder;

    @FXML
    private Button orderDeluxe;

    @FXML
    private Button orderHawaiian;

    @FXML
    private Button orderPepperoni;

    @FXML
    private TextField phoneNumber;

    @FXML
    private Button storeOrders;

    @FXML
    void onOrderDeluxeButtonClick(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Ordering Pizzas");
        alert.setContentText("Starting a new order!");
        alert.showAndWait();

        selectedPizza = PizzaMaker.createPizza("Deluxe");

        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "pizza-customization.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Customize your Pizza");
        stage.setScene(new Scene(loader.load()));

        PizzaCustomizationController pizzaCustomizationController = loader.getController();
        pizzaCustomizationController.setMainMenuController(this);

        stage.show();

    }

    private Pizza selectedPizza;
    private String selectedPizzaImg;
    public Pizza getSelectedPizza() {
        return this.selectedPizza;
    }
    public String getSelectedPizzaImg() {
        return this.selectedPizzaImg;
    }

    @FXML
    void onOrderHawaiianButtonClick(ActionEvent event) {

    }

    @FXML
    void onOrderPepperoniButtonClick(ActionEvent event) {

    }

    @FXML
    void onCurrentOrderButtonClick(ActionEvent event) {

    }

    @FXML
    void onStoreOrdersButtonClick(ActionEvent event) {

    }
}