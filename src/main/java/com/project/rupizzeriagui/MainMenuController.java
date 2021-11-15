package com.project.rupizzeriagui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    private static final int PHONE_NUMBER_DIGITS = 10;
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
    private StoreOrders orders;
    private Pizza selectedPizza;
    private Image selectedPizzaImg;
    private Order selectedOrder;

    @FXML
    public void initialize() {
        this.orders = new StoreOrders();
    }

    @FXML
    void onOrderDeluxeButtonClick(ActionEvent event) throws IOException {
        if (phoneNumber.getText().length() != PHONE_NUMBER_DIGITS ||
                !(phoneNumber.getText()
                        .matches("[0-9]+"))) {
            invalidPhoneNumberAlert();
            return;
        }
        if (selectedOrder == null || !selectedOrder.getPhoneNumber()
                .equals(phoneNumber.getText())) {
            selectedOrder = new Order(phoneNumber.getText());
            confirmCreateNewPizza();
        }

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
    void onOrderHawaiianButtonClick(ActionEvent event) throws IOException {
        if (phoneNumber.getText().length() != PHONE_NUMBER_DIGITS ||
                !(phoneNumber.getText()
                        .matches("[0-9]+"))) {
            invalidPhoneNumberAlert();
            return;
        }
        if (selectedOrder == null || !selectedOrder.getPhoneNumber()
                .equals(phoneNumber.getText())) {
            selectedOrder = new Order(phoneNumber.getText());
            confirmCreateNewPizza();
        }

        selectedPizza = PizzaMaker.createPizza("Hawaiian");
        selectedPizzaImg = new Image(getClass().getResourceAsStream(
                "Hawaiian_Pizza.jpg"));

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
    void onOrderPepperoniButtonClick(ActionEvent event) throws IOException {
        if (phoneNumber.getText().length() != PHONE_NUMBER_DIGITS ||
                !(phoneNumber.getText()
                        .matches("[0-9]+"))) {
            invalidPhoneNumberAlert();
            return;
        }
        if (selectedOrder == null || !selectedOrder.getPhoneNumber()
                .equals(phoneNumber.getText())) {
            selectedOrder = new Order(phoneNumber.getText());
            confirmCreateNewPizza();
        }

        selectedPizza = PizzaMaker.createPizza("Pepperoni");
        selectedPizzaImg = new Image(getClass().getResourceAsStream(
                "Pepperoni_Pizza.jpg"));

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
    void onCurrentOrderButtonClick(ActionEvent event) throws IOException {
        if (phoneNumber.getText().length() != PHONE_NUMBER_DIGITS ||
                !(phoneNumber.getText().matches("[0-9]+"))) {
            invalidPhoneNumberAlert();
            return;
        }
        if (selectedOrder == null || !selectedOrder.getPhoneNumber()
                .equals(phoneNumber.getText())) {
            selectedOrder = new Order(phoneNumber.getText());
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "current-order.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Pizza Order Overview");
        stage.setScene(new Scene(loader.load()));
        CurrentOrderController currentOrderController =
                loader.getController();
        currentOrderController.setMainMenuController(this);
        stage.show();
    }

    @FXML
    void onStoreOrdersButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "store-orders.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Store Order Overview");
        stage.setScene(new Scene(loader.load()));
        StoreOrdersController storeOrdersController =
                loader.getController();
        storeOrdersController.setMainMenuController(this);
        stage.show();
    }

    public Pizza getSelectedPizza() {
        return this.selectedPizza;
    }

    public Image getSelectedPizzaImg() {
        return this.selectedPizzaImg;
    }

    public Order getSelectedOrder() {
        return this.selectedOrder;
    }

    public StoreOrders getOrders() {
        return this.orders;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.setText(phoneNumber);
    }

    private void invalidPhoneNumberAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invalid input data");
        alert.setHeaderText("Telephone number");
        alert.setContentText("Please input the customer's 10-digit " +
                "telephone number.");
        alert.showAndWait();
    }

    private void confirmCreateNewPizza() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Ordering Pizzas");
        alert.setContentText("Creating new pizza for customer with phone " +
                "number: " + phoneNumber.getText());
        alert.showAndWait();
    }

}