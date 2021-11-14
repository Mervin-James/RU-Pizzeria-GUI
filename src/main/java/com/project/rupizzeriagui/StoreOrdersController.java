package com.project.rupizzeriagui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class StoreOrdersController {
    private StoreOrders orders;
    private Order selectedOrder;

    @FXML
    private Button cancelStoreOrder;

    @FXML
    private ListView<Pizza> pizzasInSelectedOrder;

    @FXML
    private ComboBox<String> customerPhoneNumber;

    @FXML
    private Button exportStoreOrder;

    @FXML
    private TextField orderTotal;

    public void setMainMenuController(MainMenuController controller) {
        orders = controller.getOrders();
        if (!orders.getOrders().isEmpty()) {
            selectedOrder = orders.getOrders().get(0);
            populateFields();
        }
        updateListView();
    }

    private void populateFields() {
        ArrayList<String> phoneNumbers = new ArrayList<>();
        for (int i = 0; i < orders.getOrders().size(); i++) {
            phoneNumbers.add(orders.getOrders().get(i).getPhoneNumber());
        }
        customerPhoneNumber.setItems(FXCollections.observableArrayList(
                phoneNumbers));
        customerPhoneNumber.setValue(selectedOrder.getPhoneNumber());
        ObservableList<Pizza> pizzas =
                FXCollections.observableArrayList(selectedOrder.getPizzas());
        pizzasInSelectedOrder.setItems(pizzas);
    }

    private void updateListView() {
        DecimalFormat df = new DecimalFormat("###,##0.00");

        boolean isOrdersEmpty = orders.getOrders().isEmpty();
        cancelStoreOrder.setDisable(isOrdersEmpty);
        exportStoreOrder.setDisable(isOrdersEmpty);
        if (!isOrdersEmpty && selectedOrder != null) {
            orderTotal.setText(df.format(selectedOrder.orderTotal()));
            pizzasInSelectedOrder.setItems(FXCollections.observableArrayList(
                    selectedOrder.getPizzas()));
            customerPhoneNumber.setValue(selectedOrder.getPhoneNumber());
        } else {
            orderTotal.setText("");
            pizzasInSelectedOrder.setItems(FXCollections.observableArrayList(
                    new ArrayList<>()));
            customerPhoneNumber.setValue(null);
        }
    }

    @FXML
    void onCancelOrderClick(ActionEvent event) {
        orders.removeOrder(selectedOrder);
        customerPhoneNumber.getItems().remove(selectedOrder.getPhoneNumber());
        if (orders.getOrders().isEmpty()) {
            selectedOrder = null;
            customerPhoneNumber.setValue("");
        } else {
            selectedOrder = orders.getOrders().get(0);
        }
        updateListView();

    }

    @FXML
    void onExportStoreOrderClick(ActionEvent event)
            throws FileNotFoundException {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Target File for the Export");
        chooser.getExtensionFilters()
                .addAll(new ExtensionFilter("Text Files", "*.txt"),
                        new ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
        File targetFile = chooser.showSaveDialog(stage);
        orders.export(targetFile);
    }

    @FXML
    void selectedCustomerPhoneNumber(ActionEvent event) {
        if(customerPhoneNumber.getValue() == null) return;
        for (int i = 0; i < orders.getOrders().size(); i++) {
            if (customerPhoneNumber.getValue()
                    .equals(orders.getOrders().get(i).getPhoneNumber())) {
                selectedOrder = orders.getOrders().get(i);
                updateListView();
                return;
            }
        }
    }
}