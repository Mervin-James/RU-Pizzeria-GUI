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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

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

    @FXML
    void onOrderDeluxeButtonClick(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Ordering Pizzas");
        alert.setContentText("Starting a new order!");
        alert.showAndWait();

        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "pizza-customization.fxml"));
        AnchorPane root = (AnchorPane) loader.load();
        Scene scene = new Scene(root, 600, 800);
        Stage stage = new Stage();
        stage.setTitle("Customize your Pizza");
        stage.setScene(scene);
        stage.show();

//        PizzaCustomizationController pizzaCustomizationController = loader.getController();
//        pizzaCustomizationController.setMainMenuController(this);

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
}