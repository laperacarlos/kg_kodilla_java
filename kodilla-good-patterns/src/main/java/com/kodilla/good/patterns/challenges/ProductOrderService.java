package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    private final InformationService informationService;
    private final OrderDatabase orderDatabase;
    private final ProductDatabase productDatabase;

    public ProductOrderService(final InformationService informationService, final OrderDatabase orderDatabase, final ProductDatabase productDatabase) {
        this.informationService = informationService;
        this.orderDatabase = orderDatabase;
        this.productDatabase = productDatabase;
    }

    public OrderDto processOrder(final OrderRequest orderRequest) {

        if (productDatabase.checkAvailability(orderRequest)) {
            informationService.sendOrderConfirmation(orderRequest.getUser());
            orderDatabase.addOrderToRealization(orderRequest);
            System.out.println("Order no: " + orderRequest.getOrderId() + " is confirmed. Final price of order: " + orderRequest.getFinalPrice() + "PLN");
            return new OrderDto(orderRequest.getOrderId(), true);
        } else {
            informationService.sendRejectInformation(orderRequest.getUser());
            orderDatabase.addRejectedOrder(orderRequest);
            System.out.println("Order no: " + orderRequest.getOrderId() + " has been rejected. Please contact us for further information.");
            return new OrderDto(orderRequest.getOrderId(), false);
        }
    }
}
