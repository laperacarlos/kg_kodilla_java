package food2door.supplier.service;

public class OrderService {
    private final Supplier supplier;
    private final RequestInterface requestInterface;
    private final InformationService informationService;

    public OrderService(final Supplier supplier, final RequestInterface requestInterface, final InformationService informationService) {
        this.supplier = supplier;
        this.requestInterface = requestInterface;
        this.informationService = informationService;
    }

    public void process() {
        if (supplier.process(requestInterface).isOrderStatus()) {
            informationService.sendOrderConfirmation(requestInterface.getUser());
            System.out.println("Order no. " + requestInterface.getOrderId() + " is confirmed");
        } else {
            informationService.sendRejectInformation((requestInterface.getUser()));
            System.out.println("Order no. " + requestInterface.getOrderId() + " is rejected");
        }
    }
}
