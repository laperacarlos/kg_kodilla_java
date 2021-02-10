package com.kodilla.good.patterns.challenges;

import java.util.List;

public class OrderRequest {
    private final int orderId;
    private final User user;
    private final List<ProductData> listOfProducts;

    public OrderRequest(final int orderId, final User user, final List<ProductData> listOfProducts) {
        this.orderId = orderId;
        this.user = user;
        this.listOfProducts = listOfProducts;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<ProductData> getListOfProducts() {
        return listOfProducts;
    }

    public User getUser() {
        return user;
    }
    public double getFinalPrice() {
        return listOfProducts.stream()
                .mapToDouble(ProductData::getPriceToOrder)
                .sum();
    }

    public boolean checkAvailability() {
        return true;
    }
}
