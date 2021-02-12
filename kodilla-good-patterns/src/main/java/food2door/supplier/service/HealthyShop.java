package food2door.supplier.service;

import java.util.List;

public class HealthyShop implements Supplier {
    private final List<ProductData> shopProductDatabase;

    public HealthyShop(List<ProductData> shopProductDatabase) {
        this.shopProductDatabase = shopProductDatabase;
    }

    public OrderDto process(Request request){
        if(externalRequest(request.getListOfProducts())) {
            return new OrderDto(request.getOrderId(), true);
        } else {
            return new OrderDto(request.getOrderId(), false);
        }
    }

    private boolean externalRequest(List<ProductData> listToCheck) {
        return true;
    }

    public List<ProductData> getProductDatabase(){
        return shopProductDatabase;
    }
}
