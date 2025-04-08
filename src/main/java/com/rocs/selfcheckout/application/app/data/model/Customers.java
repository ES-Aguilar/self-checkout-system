package com.rocs.selfcheckout.application.app.data.model;

public class Customers {
    private String customerId;
    private String name;
    private String address;
    private String contactNumber;

    public Customers (String customerId, String name, String address, String contactNumber) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Customers other) {
            return this.customerId.equals(other.customerId);
        }
        return false;
    }
}
