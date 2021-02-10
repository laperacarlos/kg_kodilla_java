package com.kodilla.good.patterns.challenges;

public class ProductToBeAddToOrder implements ProductData {
    private final String productName;
    private final int productId;
    private final int quantity;
    private final double unitPrice;

    public ProductToBeAddToOrder(final String productName, final int productId, final int quantity, double unitPrice) {
        this.productName = productName;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public int getProductId() {
        return productId;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public double getPriceToOrder() {
        return quantity * unitPrice;
    }

}
