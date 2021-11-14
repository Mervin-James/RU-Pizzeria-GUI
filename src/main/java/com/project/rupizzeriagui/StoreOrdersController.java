package com.project.rupizzeriagui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
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
        populateFields();
        updateListView();
    }

    private void populateFields() {
        ArrayList<Order> ordersList = orders.getOrders();
        if (!ordersList.isEmpty()) {
            selectedOrder = ordersList.get(0);

            ArrayList<String> phoneNumbers = new ArrayList<>();
            ordersList.forEach(order -> phoneNumbers.add(order.getPhoneNumber()));
            customerPhoneNumber.setItems(FXCollections.observableArrayList(
                    phoneNumbers));
            customerPhoneNumber.setValue(selectedOrder.getPhoneNumber());

            ObservableList<Pizza> pizzas =
                    FXCollections.observableArrayList(selectedOrder.getPizzas());
            pizzasInSelectedOrder.setItems(pizzas);
        }
    }

    private void updateListView() {
        DecimalFormat df = new DecimalFormat("###,##0.00");
        boolean isOrdersEmpty = orders.getOrders().isEmpty();
        cancelStoreOrder.setDisable(isOrdersEmpty);
        exportStoreOrder.setDisable(isOrdersEmpty);
        if (selectedOrder != null &&
                orders.getOrders().contains(selectedOrder)) {
            customerPhoneNumber.setValue(selectedOrder.getPhoneNumber());
            orderTotal.setText(df.format(selectedOrder.subtotal()));
            pizzasInSelectedOrder.setItems(FXCollections.observableArrayList(
                    selectedOrder.getPizzas()));
        } else if ((selectedOrder != null &&
                !orders.getOrders().contains(selectedOrder)) ||
                (selectedOrder == null && !isOrdersEmpty)) {
            selectedOrder = orders.getOrders().get(0);
            customerPhoneNumber.setValue(selectedOrder.getPhoneNumber());
            orderTotal.setText(df.format(selectedOrder.subtotal()));
            pizzasInSelectedOrder.setItems(FXCollections.observableArrayList(
                    selectedOrder.getPizzas()));
        } else {
            customerPhoneNumber.setValue(null);
            orderTotal.setText("");
            pizzasInSelectedOrder.setItems(FXCollections.observableArrayList(
                    new ArrayList<Pizza>()));
        }
    }

    @FXML
    void onCancelOrderClick(ActionEvent event) {
        orders.removeOrder(selectedOrder);
        customerPhoneNumber.getItems().remove(selectedOrder.getPhoneNumber());
    }

    @FXML
    void selectedCustomerPhoneNumber(ActionEvent event) {
        selectedOrder = null;
        String selectedPhoneNumber = customerPhoneNumber.getValue();
        if (selectedPhoneNumber != null) {
            Order foundOrder = null;
            for (Order order : orders.getOrders()) {
                if (selectedPhoneNumber.equals(order.getPhoneNumber())) {
                    foundOrder = order;
                    break;
                }
            }
            selectedOrder = foundOrder;
        }
        updateListView();
    }

    @FXML
    void onExportStoreOrderClick(ActionEvent event) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Open Target Directory for the Export");
//        chooser.getExtensionFilters()
//                .addAll(new ExtensionFilter("Text Files", "*.txt"),
//                        new ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
//        File defaultDirectory = new File("Store_Orders.txt");
//        chooser.setInitialDirectory(defaultDirectory);
        File selectedDirectory = chooser.showDialog(stage);
//        File targetFile = chooser.showSaveDialog(stage);
        try {
            orders.export(selectedDirectory);
        } catch (FileNotFoundException e) {}
    }


}