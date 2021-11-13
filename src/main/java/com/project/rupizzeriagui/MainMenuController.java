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
import javafx.scene.image.Image;
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

    private Pizza selectedPizza;
    private Image selectedPizzaImg;
    private StoreOrders orders;

    @FXML
    void onOrderDeluxeButtonClick(ActionEvent event) throws IOException {

        if (!phoneNumberValidation()) return;

        selectedPizza = PizzaMaker.createPizza("Deluxe");
        selectedPizzaImg = new Image(getClass().getResourceAsStream(
                        "Deluxe_Pizza.jpg"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "pizza-customization.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Customize your Pizza");
        stage.setScene(new Scene(loader.load()));

        PizzaCustomizationController pizzaCustomizationController =
                loader.getController();
        pizzaCustomizationController.setMainMenuController(this);

        stage.show();

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

    public Pizza getSelectedPizza() {
        return this.selectedPizza;
    }

    public Image getSelectedPizzaImg() {
        return this.selectedPizzaImg;
    }

    private boolean phoneNumberValidation() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (phoneNumber.getText().length() != 10) {
            alert.setTitle("Missing input data");
            alert.setHeaderText("Telephone number missing");
            alert.setContentText("Please input a 10-digit telephone number.");
            alert.showAndWait();
            return false;
        }
        alert.setTitle("Confirmation");
        alert.setHeaderText("Ordering Pizzas");
        alert.setContentText("Creating new pizza for customer with phone " +
                "number: " + phoneNumber.getText());
        alert.showAndWait();
        return true;
    }
}