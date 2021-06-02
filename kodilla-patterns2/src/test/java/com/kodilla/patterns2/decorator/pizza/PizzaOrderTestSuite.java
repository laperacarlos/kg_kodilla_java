package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PizzaOrderTestSuite {

    @Test
    void testMargheritaOrderGetCost() {
        //given
        PizzaOrder margheritaPizzaOrder = new MargheritaPizzaOrder();
        //when
        BigDecimal cost = margheritaPizzaOrder.getCost();
        //then
        assertEquals(new BigDecimal(20), cost);
    }

    @Test
    void testMargheritaOrderGetIngredients() {
        //given
        PizzaOrder margheritaPizzaOrder = new MargheritaPizzaOrder();
        //when
        String ingredients = margheritaPizzaOrder.getIngredients();
        //then
        assertEquals("Ingredients: tomato sauce, mozzarella, basil", ingredients);
    }

    @Test
    void testMargheritaOrderGetName() {
        //given
        PizzaOrder margheritaPizzaOrder = new MargheritaPizzaOrder();
        //when
        String name = margheritaPizzaOrder.getName();
        //then
        assertEquals("Margherita", name);
    }

    @Test
    void testCapricciosaOrderOnThickCrustWithExtraCheeseAndOlives() {
        //given
        PizzaOrder pizzaOrder = new MargheritaPizzaOrder();
        pizzaOrder = new CapricciosaPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new ThickCrustOrderDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheeseOrderDecorator(pizzaOrder);
        pizzaOrder = new ExtraOlivesOrderDecorator(pizzaOrder);

        //when
        String name = pizzaOrder.getName();
        String ingredients = pizzaOrder.getIngredients();
        BigDecimal cost = pizzaOrder.getCost();

        //then
        assertEquals("Capricciosa", name);
        assertEquals("On thick crust. Ingredients: tomato sauce, mozzarella, basil, ham, mushrooms + extra cheese + extra olives", ingredients);
        assertEquals(new BigDecimal(40), cost);
    }


}
