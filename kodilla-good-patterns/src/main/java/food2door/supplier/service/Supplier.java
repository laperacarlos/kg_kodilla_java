package food2door.supplier.service;

import java.util.List;

public interface Supplier {
    int getSupplierId();
    String getSupplierName();
    OrderDto process(RequestInterface requestInterface);
    List<ProductData> getProductDatabase();
}
