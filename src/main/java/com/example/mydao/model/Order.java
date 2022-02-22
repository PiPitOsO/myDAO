package com.example.mydao.model;

public class Order {
    private String name;
    private String product;
    private int amount;

    public Order(String name, String product, int amount) {
        this.name = name;
        this.product = product;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return name + " ordered " + product + " in quantity: " + amount;
    }
}
