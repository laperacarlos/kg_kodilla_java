package food2door.supplier.service;

public class NewProduct implements ProductData {
    private final int productId;
    private final String productName;
    private final int quantity;

    public NewProduct(int productId, String productName, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
    }

    @Override
    public int getProductId() {
        return productId;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
}
