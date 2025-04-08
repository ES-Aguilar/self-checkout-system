package com.rocs.selfcheckout.application.app.data.model;

public class Cart {
    private String itemId;
    private String description;
    private int quantity;

    public Cart(String itemId, String description, int quantity) {
        this.itemId = itemId;
        this.description = description;
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }
}
