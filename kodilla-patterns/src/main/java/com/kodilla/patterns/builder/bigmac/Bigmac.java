package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {

    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private List<Ingredient> ingredients;

    private Bigmac(final Bun bun, final int burgers, final Sauce sauce, List<Ingredient> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public static class BigmacBuilder {
        private Bun bun;
        private int burgers;
        private Sauce sauce;
        private List<Ingredient> ingredients = new ArrayList<>();

        public BigmacBuilder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgersQuantity(int burgers) {
           this.burgers = burgers;
           return this;
        }

        public BigmacBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(Ingredient ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            int minNumberOfBurgers = 1;
            int maxNumberOfBurgers = 3;

            if (bun == null) {
                throw new IllegalStateException("You have to choose bun type (standard or sesame) for your Bigmac!");
            }
            if (sauce == null) {
                throw new IllegalStateException("You have to choose one of sauces (standard, thousand islands or barbecue) for your Bigmac!");
            }
            if (burgers < minNumberOfBurgers || burgers > maxNumberOfBurgers) {
                throw new IllegalStateException("Number of burgers shall be between " + minNumberOfBurgers + " and " + maxNumberOfBurgers);
            }
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun=" + bun +
                ", burgers=" + burgers +
                ", sauce=" + sauce +
                ", ingredients=" + ingredients +
                '}';
    }
}
