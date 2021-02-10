package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderDataRetriever {

    public OrderRequest retrieve() {
        User user = new User("mario", "Mariusz", "Plumber", "mario@email.com", 666666666);

        ProductToBeAddToOrder productToBeAddToOrder1 = new ProductToBeAddToOrder("Rękawice murarskie", 6745, 2, 7.5);
        ProductToBeAddToOrder productToBeAddToOrder2 = new ProductToBeAddToOrder("Xbox 360", 2299, 1, 10);

        List<ProductData> listToOrder = new ArrayList<>(Arrays.asList(productToBeAddToOrder1, productToBeAddToOrder2));
        return new OrderRequest(777, user, listToOrder);
    }
}
