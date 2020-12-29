package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World {
    private final String worldName;
    private final List<Continent> continentsList = new ArrayList<>();

    public World(String worldName) {
        this.worldName = worldName;
    }

    public void addContinent(Continent continent) {
        continentsList.add(continent);
    }

    public BigDecimal getPeopleQuantity() {
        return continentsList.stream()
                .flatMap(continent -> continent.getCountryList().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum.add(current));
    }
}
