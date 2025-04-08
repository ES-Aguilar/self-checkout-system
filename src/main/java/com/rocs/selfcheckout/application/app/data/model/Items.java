package com.rocs.selfcheckout.application.app.data.model;

public class Items {
    private String itemId;
    private String description;
    private double unitPrice;

    public Items (String itemId, String description, double unitPrice) {
        this.itemId = itemId;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Items other) {  // Pattern matching here
            return this.itemId.equals(other.itemId);
        }
        return false;
    }
}
