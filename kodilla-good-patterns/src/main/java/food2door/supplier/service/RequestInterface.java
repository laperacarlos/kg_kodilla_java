package food2door.supplier.service;

import java.util.List;

public interface RequestInterface {
    int getOrderId();
    List<ProductData> getListOfProducts();
    UserInterface getUser();
}
