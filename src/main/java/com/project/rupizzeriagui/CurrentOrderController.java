package com.project.rupizzeriagui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CurrentOrderController {

    @FXML
    private ListView<?> currentOrders;

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

}
