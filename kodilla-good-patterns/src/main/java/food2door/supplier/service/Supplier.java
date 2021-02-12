package food2door.supplier.service;

import java.util.List;

public interface Supplier {
    OrderDto process(Request request);
    List<ProductData> getProductDatabase();
}
