package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ThickCrustOrderDecorator extends AbstractPizzaOrderDecorator {

    public ThickCrustOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public String getIngredients() {
        return "On thick crust. " + super.getIngredients();
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(3));
    }
}
