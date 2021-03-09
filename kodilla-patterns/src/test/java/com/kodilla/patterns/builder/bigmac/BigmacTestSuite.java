package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test//
    void testBigmacComposer() {

        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bun.SESAME_BUN)
                .burgersQuantity(3)
                .sauce(Sauce.BARBECUE)
                .ingredient(Ingredient.BACON)
                .ingredient(Ingredient.CHILLI_PEPPERS)
                .ingredient(Ingredient.LETTUCE)
                .ingredient(Ingredient.CHEESE)
                .build();
        System.out.println(bigmac);

        //When
        Bun bun = bigmac.getBun();
        int numberOfIngredients = bigmac.getIngredients().size();
        int numberOfBurgers = bigmac.getBurgers();
        Sauce sauce = bigmac.getSauce();

        //Then
        assertEquals(Bun.SESAME_BUN, bun);
        assertEquals(4, numberOfIngredients);
        assertEquals(3, numberOfBurgers);
        assertEquals(Sauce.BARBECUE, sauce);
    }
}
