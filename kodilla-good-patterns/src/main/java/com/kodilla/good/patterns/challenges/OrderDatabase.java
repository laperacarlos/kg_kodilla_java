package com.kodilla.good.patterns.challenges;

public interface OrderDatabase {
    void addOrderToRealization(OrderRequest orderRequest);

    void addRejectedOrder(OrderRequest orderRequest);
}
