package com.project.rupizzeriagui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StoreOrdersController {

    @FXML
    private Button cancelStoreOrder;

    @FXML
    private ListView<?> currentOrders;

    @FXML
    private ComboBox<?> customerPhoneNumber;

    @FXML
    private Button exportStoreOrder;

    @FXML
    private TextField orderTotal;

}
