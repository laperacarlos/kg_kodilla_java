package food2door.supplier.service;

import java.util.List;

public class ExtraFoodShop implements Supplier {
    private final int supplierId = 666;
    private final String supplierName = "ExtraFoodShop";
    private List<ProductData> shopProductDatabase;

    public OrderDto process(RequestInterface requestInterface){
        if(checkInDatabase(requestInterface.getListOfProducts())) {
            return new OrderDto(requestInterface.getOrderId(), true);
        } else {
            return new OrderDto(requestInterface.getOrderId(), false);
        }
    }

    private boolean checkInDatabase(List<ProductData> listToCheck) {
        return true;
    }

    public List<ProductData> getProductDatabase(){
        return shopProductDatabase;
    }

   public int getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }
}
