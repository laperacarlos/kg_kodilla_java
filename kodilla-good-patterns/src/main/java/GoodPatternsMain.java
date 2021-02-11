import com.kodilla.good.patterns.challenges.*;

public class GoodPatternsMain {

    public static void main(String[] args) {

        System.out.println("\nTask 13.1");
        //Task 13.1
        MovieStore movieStore = new MovieStore();

        System.out.println(movieStore.storePrintOut());


        System.out.println("\nTask 13.2");
        //Task 13.2
        OrderDataRetriever orderDataRetriever = new OrderDataRetriever();
        OrderRequest orderRequest = orderDataRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService(new ThisStoreInformationService(), new ThisStoreDatabase(), new ThisStoreCheckProductAvailability());

        productOrderService.processOrder(orderRequest);
    }
}


