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

public class CurrentOrderController {
    private Order currentOrder;
    private StoreOrders orders;
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

    public void setMainMenuController(MainMenuController controller) {
        currentOrder = controller.getSelectedOrder();
        orders = controller.getOrders();
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

    private void populateFields() {
        customerPhoneNumber.setText(currentOrder.getPhoneNumber());
        ObservableList<Pizza> pizzas =
                FXCollections.observableArrayList(currentOrder.getPizzas());
        pizzasInOrder.setItems(pizzas);
    }

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

    @FXML
    void onPlaceOrderClick(ActionEvent event) {
        orders.addOrder(currentOrder);
        subtotal.setText("");
        salesTax.setText("");
        orderTotal.setText("");
        customerPhoneNumber.setText("");
        pizzasInOrder.setItems(null);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Placing Order");
        alert.setContentText("Order added!");
        alert.showAndWait();
        Stage stage = (Stage) placeOrder.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onRemovePizzaClick(ActionEvent event) {
        Pizza pizzaToRemove = pizzasInOrder.getSelectionModel()
                .getSelectedItem();
        currentOrder.removePizza(pizzaToRemove);
        pizzasInOrder.getItems().remove(pizzaToRemove);
    }
}


