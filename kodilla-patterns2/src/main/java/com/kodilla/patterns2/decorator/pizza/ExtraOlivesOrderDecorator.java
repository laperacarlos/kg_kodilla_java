package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraOlivesOrderDecorator extends AbstractPizzaOrderDecorator {

    public ExtraOlivesOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + " + extra olives";
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(5));
    }
}
