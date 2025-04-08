package com.rocs.selfcheckout.application.app;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import com.rocs.selfcheckout.application.app.data.model.Cart;

public class MainController {

    @FXML
    private TableView<Cart> tableView;
    @FXML
    private TableColumn<Cart, String> itemCodeColumn, itemColumn;
    @FXML
    private TableColumn<Cart, Integer> quantityColumn;
    @FXML
    private TextField customerIdField, customerNameField, itemIdField, descriptionField, quantityField;
    @FXML
    private Button checkoutButton, addToCartButton;

    private ObservableList<Cart> cartItems = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        itemCodeColumn.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue().getItemId()));
        itemColumn.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDescription()));
        quantityColumn.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getQuantity()).asObject());

        tableView.setItems(cartItems);
    }

    @FXML
    private void handleAddToCart(ActionEvent event) {
        String itemId = itemIdField.getText();
        String description = descriptionField.getText();
        String quantityText = quantityField.getText();

        if (itemId.isEmpty() || description.isEmpty() || quantityText.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Missing information");
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid quantity");
            alert.setContentText("Please enter a valid quantity.");
            alert.showAndWait();
            return;
        }

        Cart cartItem = new Cart(itemId, description, quantity);
        cartItems.add(cartItem);

        System.out.println("Adding to cart: " + itemId + " - " + description + " x " + quantity);
    }

    @FXML
    private void handleCheckout(ActionEvent event) {
        System.out.println("Checkout initiated.");
    }
}
