package food2door.supplier.service;

import java.util.List;

public interface Request {
    int getOrderId();
    List<ProductData> getListOfProducts();
    Supplier getSupplier();
}
