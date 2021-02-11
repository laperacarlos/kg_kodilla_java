package food2door.supplier.service;

public class OrderDto {
    int orderId;
    boolean orderStatus;

    public OrderDto(int orderId, boolean orderStatus) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }
}
