package food2door.supplier.service;

import java.util.List;

public class NewRequest implements Request {
    private final int orderId;
    private final Supplier supplier;
    private final List<ProductData> listOfProducts;

    public NewRequest(int orderId, Supplier supplier, List<ProductData> listOfProducts) {
        this.orderId = orderId;
        this.supplier = supplier;
        this.listOfProducts = listOfProducts;
    }

    @Override
    public int getOrderId() {
        return orderId;
    }

    @Override
    public Supplier getSupplier() {
        return supplier;
    }

    @Override
    public List<ProductData> getListOfProducts() {
        return listOfProducts;
    }
}
