package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class MargheritaPizzaOrder implements PizzaOrder {

    @Override
    public String getName() {
        return "Margherita";
    }

    @Override
    public String getIngredients() {
        return "Ingredients: tomato sauce, mozzarella, basil";
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(20);
    }
}
