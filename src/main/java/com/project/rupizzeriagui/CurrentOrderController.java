package com.project.rupizzeriagui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.DecimalFormat;

/**
 * Controller class that specifies the attributes and actions for the
 * Current Order GUI.
 *
 * @author Mervin James, Akshar Patel
 */
public class CurrentOrderController {
    private Order currentOrder;
    private StoreOrders orders;
    private MainMenuController mainMenuController;

    @FXML
    private ListView<Pizza> pizzasInOrder;

    @FXML
    private TextField customerPhoneNumber;

    @FXML
    private TextField orderTotal;

    @FXML
    private Button placeOrder;

    @FXML
    private Button removePizza;

    @FXML
    private TextField salesTax;

    @FXML
    private TextField subtotal;

    /**
     * Sets the controller to the MainMenuController so that
     * CurrentOrderController can share data with MainMenuController.
     *
     * @param controller instance of MainMenuController
     */
    public void setMainMenuController(MainMenuController controller) {
        this.mainMenuController = controller;
        currentOrder = mainMenuController.getSelectedOrder();
        orders = mainMenuController.getOrders();
        pizzasInOrder.getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<Pizza>() {
                    @Override
                    public void changed(
                            ObservableValue<? extends Pizza> observable,
                            Pizza old, Pizza newValue) {
                        updateListView();
                    }
                });
        populateFields();
        updateListView();
    }

    /**
     * Populates the fields of the Current Order GUI.
     */
    private void populateFields() {
        customerPhoneNumber.setText(currentOrder.getPhoneNumber());
        ObservableList<Pizza> pizzas =
                FXCollections.observableArrayList(currentOrder.getPizzas());
        pizzasInOrder.setItems(pizzas);
    }

    /**
     * Updates the list view for pizza orders.
     */
    private void updateListView() {
        DecimalFormat df = new DecimalFormat("###,##0.00");
        removePizza.setDisable(
                currentOrder.getPizzas().isEmpty() ||
                        pizzasInOrder.getSelectionModel()
                                .getSelectedItem() == null);
        placeOrder.setDisable(currentOrder.getPizzas()
                .isEmpty());
        subtotal.setText(df.format(currentOrder.subtotal()));
        salesTax.setText(df.format(currentOrder.salesTax()));
        orderTotal.setText(df.format(currentOrder.orderTotal()));
    }

    /**
     * Adds current order to store orders and creates an alert to inform
     * user that an order has been placed.
     *
     * @param event an event that occurs when a button is clicked.
     */
    @FXML
    void onPlaceOrderClick(ActionEvent event) {
        orders.addOrder(currentOrder);
        subtotal.setText("");
        salesTax.setText("");
        orderTotal.setText("");
        customerPhoneNumber.setText("");
        pizzasInOrder.setItems(null);
        mainMenuController.setPhoneNumber("");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Placing Order");
        alert.setContentText("Order added!");
        alert.showAndWait();
        Stage stage = (Stage) placeOrder.getScene().getWindow();
        stage.close();
    }

    /**
     * Removes pizza from current order.
     *
     * @param event an event that occurs when a button is clicked.
     */
    @FXML
    void onRemovePizzaClick(ActionEvent event) {
        Pizza pizzaToRemove = pizzasInOrder.getSelectionModel()
                .getSelectedItem();
        currentOrder.removePizza(pizzaToRemove);
        pizzasInOrder.getItems().remove(pizzaToRemove);
    }
}


