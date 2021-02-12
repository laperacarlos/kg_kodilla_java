package food2door.supplier.service;

public class OrderService {

    public OrderDto process (Request request) {
        if (request.getSupplier().process(request).isOrderStatus()) {
            System.out.println("Order no. " + request.getOrderId() + " is confirmed");
        } else {
            System.out.println("Order no. " + request.getOrderId() + " is rejected");
        }
        return request.getSupplier().process(request);
    }
}
