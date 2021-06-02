package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public abstract class AbstractPizzaOrderDecorator implements PizzaOrder {
    private final PizzaOrder pizzaOrder;

    protected AbstractPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public String getName() {
        return pizzaOrder.getName();
    }

    @Override
    public String getIngredients() {
        return pizzaOrder.getIngredients();
    }

    @Override
    public BigDecimal getCost() {
        return pizzaOrder.getCost();
    }
}
