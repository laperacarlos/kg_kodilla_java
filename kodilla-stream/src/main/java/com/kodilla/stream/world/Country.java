package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class Country {
    private final String countryName;
    private final int peopleQuantity;

    public Country(final String countryName, final int peopleQuantity) {
        this.countryName = countryName;
        this.peopleQuantity = peopleQuantity;
    }

    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQty = new BigDecimal(peopleQuantity);
        return peopleQty;
    }


}
