package food2door.supplier.service;

import java.util.List;

public class ExtraFoodShop implements Supplier {
    private final List<ProductData> shopProductDatabase;

    public ExtraFoodShop(List<ProductData> shopProductDatabase) {
        this.shopProductDatabase = shopProductDatabase;
    }

    public OrderDto process(Request request){
        if(checkInDatabase(request.getListOfProducts())) {
            return new OrderDto(request.getOrderId(), true);
        } else {
            return new OrderDto(request.getOrderId(), false);
        }
    }

    private boolean checkInDatabase(List<ProductData> listToCheck) {
        return true;
    }

    public List<ProductData> getProductDatabase(){
        return shopProductDatabase;
    }
}
