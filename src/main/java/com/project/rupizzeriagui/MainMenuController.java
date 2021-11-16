package com.project.rupizzeriagui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller class that specifies the attributes and actions for the
 * Main Menu GUI.
 *
 * @author Mervin James, Akshar Patel
 */
public class MainMenuController {

    private static final int PHONE_NUMBER_DIGITS = 10;
    @FXML
    private TextField phoneNumber;
    @FXML
    private StoreOrders orders;
    private Pizza selectedPizza;
    private Image selectedPizzaImg;
    private Order selectedOrder;

    /**
     * Initializes order by creating a new StoreOrders object.
     */
    @FXML
    public void initialize() {
        this.orders = new StoreOrders();
    }

    /**
     * Opens the Pizza Customization GUI for a Deluxe pizza and creates a new
     * order if the phone number provided is not associated with an existing
     * order.
     *
     * @param event an event that occurs when a button is clicked.
     */
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
                "pizza-customization-view.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Customize your Pizza");
        stage.setScene(new Scene(loader.load()));

        PizzaCustomizationController pizzaCustomizationController =
                loader.getController();
        pizzaCustomizationController.setMainMenuController(this);

        stage.show();
    }

    /**
     * Opens the Pizza Customization GUI for a Hawaiian pizza and creates a
     * new order if the phone number provided is not associated with an
     * existing order.
     *
     * @param event an event that occurs when a button is clicked.
     */
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
                "pizza-customization-view.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Customize your Pizza");
        stage.setScene(new Scene(loader.load()));

        PizzaCustomizationController pizzaCustomizationController =
                loader.getController();
        pizzaCustomizationController.setMainMenuController(this);

        stage.show();
    }

    /**
     * Opens the Pizza Customization GUI for a Pepperoni pizza and creates a
     * new order if the phone number provided is not associated with an
     * existing order.
     *
     * @param event an event that occurs when a button is clicked.
     */
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
                "pizza-customization-view.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Customize your Pizza");
        stage.setScene(new Scene(loader.load()));

        PizzaCustomizationController pizzaCustomizationController =
                loader.getController();
        pizzaCustomizationController.setMainMenuController(this);

        stage.show();
    }

    /**
     * Opens the Current Order GUI and creates a new order if the phone number
     * provided is not associated with an existing order.
     *
     * @param event an event that occurs when a button is clicked.
     * @throws IOException exception caused by an input/output error.
     */
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
                "current-order-view.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Pizza Order Overview");
        stage.setScene(new Scene(loader.load()));
        CurrentOrderController currentOrderController =
                loader.getController();
        currentOrderController.setMainMenuController(this);
        stage.show();
    }

    /**
     * Opens the Store Order GUI.
     *
     * @param event an event that occurs when a button is clicked.
     * @throws IOException exception caused by an input/output error.
     */
    @FXML
    void onStoreOrdersButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "store-orders-view.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Store Order Overview");
        stage.setScene(new Scene(loader.load()));
        StoreOrdersController storeOrdersController =
                loader.getController();
        storeOrdersController.setMainMenuController(this);
        stage.show();
    }

    /**
     * Getter method for the selected pizza.
     *
     * @return selected pizza.
     */
    public Pizza getSelectedPizza() {
        return this.selectedPizza;
    }

    /**
     * Getter method for the selected pizza image.
     *
     * @return selected pizza image.
     */
    public Image getSelectedPizzaImg() {
        return this.selectedPizzaImg;
    }

    /**
     * Getter method for the selected order.
     *
     * @return selected order.
     */
    public Order getSelectedOrder() {
        return this.selectedOrder;
    }

    /**
     * Getter method for store orders.
     *
     * @return store orders.
     */
    public StoreOrders getOrders() {
        return this.orders;
    }

    /**
     * Setter method for the phone number associated with an order.
     *
     * @param phoneNumber the phone number associated with this order.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.setText(phoneNumber);
    }

    /**
     * Creates an alert to informs the user to input a 10-digit phone number.
     */
    private void invalidPhoneNumberAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invalid input data");
        alert.setHeaderText("Telephone number");
        alert.setContentText("Please input the customer's 10-digit " +
                "telephone number.");
        alert.showAndWait();
    }

    /**
     * Creates an alert to informs the user that a new pizza is being created.
     */
    private void confirmCreateNewPizza() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Ordering Pizzas");
        alert.setContentText("Creating new pizza for customer with phone " +
                "number: " + phoneNumber.getText());
        alert.showAndWait();
    }

}