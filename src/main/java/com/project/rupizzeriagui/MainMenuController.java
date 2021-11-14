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

    private StoreOrders orders;
    private Pizza selectedPizza;
    private Image selectedPizzaImg;
    private Order selectedOrder;
    private static final int PHONE_NUMBER_DIGITS = 10;

    @FXML
    public void initialize() {
        this.orders = new StoreOrders();
    }

    @FXML
    void onOrderDeluxeButtonClick(ActionEvent event) throws IOException {
        if (phoneNumber.getText().length() != PHONE_NUMBER_DIGITS || !(phoneNumber.getText()
                .matches("[0-9]+"))) {
            invalidPhoneNumberAlert();
            return;
        }
        confirmCreateNewPizza();
        loadSelectedOrder();

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
        if (phoneNumber.getText().length() != PHONE_NUMBER_DIGITS || !(phoneNumber.getText()
                .matches("[0-9]+"))) {
            invalidPhoneNumberAlert();
            return;
        }
        loadSelectedOrder();

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
        if (phoneNumber.getText().length() != PHONE_NUMBER_DIGITS || !(phoneNumber.getText()
                .matches("[0-9]+"))) {
            invalidPhoneNumberAlert();
            return;
        }
        loadSelectedOrder();

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
        if (phoneNumber.getText().length() != PHONE_NUMBER_DIGITS || !(phoneNumber.getText()
                .matches("[0-9]+"))) {
            invalidPhoneNumberAlert();
            return;
        }
        loadSelectedOrder();
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
        //TODO: DELETE CODE AFTER USED FOR TESTING
//        selectedOrder.addPizza(PizzaMaker.createPizza("Deluxe"));
//        selectedOrder.addPizza(PizzaMaker.createPizza("Hawaiian"));
        Order order1 = new Order("1234567890");
        Pizza p1 = PizzaMaker.createPizza("Deluxe");
        p1.setSize(Size.medium);
        p1.addTopping(Topping.BlackOlives);
        order1.addPizza(p1);
        Pizza p2 = PizzaMaker.createPizza("Pepperoni");
        order1.addPizza(p2);
        orders.addOrder(order1);
        Order order2 = new Order("09876543212");
        Pizza p3 = PizzaMaker.createPizza("Hawaiian");
        p3.setSize(Size.large);
        p3.addTopping(Topping.Chicken);
        order2.addPizza(p3);
        orders.addOrder(order2);

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

    private void loadSelectedOrder() {
        ArrayList<Order> storeOrders = orders.getOrders();
        for (int i = 0; i < storeOrders.size(); i++) {
            if (storeOrders.get(i)
                    .getPhoneNumber()
                    .equals(phoneNumber.getText())) {
                selectedOrder = storeOrders.get(i);
                return;
            }
        }
        selectedOrder = new Order(phoneNumber.getText());
    }
}