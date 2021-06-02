package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class CapricciosaPizzaOrderDecorator extends AbstractPizzaOrderDecorator {

    public CapricciosaPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public String getName() {
        return "Capricciosa";
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", ham, mushrooms";
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(7));
    }
}
