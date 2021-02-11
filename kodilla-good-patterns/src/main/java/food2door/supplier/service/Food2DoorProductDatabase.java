package food2door.supplier.service;

import java.util.ArrayList;
import java.util.List;

public class Food2DoorProductDatabase {
    private final List<ProductData> productDatabase = new ArrayList<>();

    public void addProductsToDataBase(Supplier supplier) {
        productDatabase.addAll(supplier.getProductDatabase());
    }

    public List<ProductData> getProductDatabase() {
        return productDatabase;
    }
}
