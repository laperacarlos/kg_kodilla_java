package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTestSuite {
    @Test
    void testGetPeopleQuantity() {
        //Given
        Country countryE1= new Country("Poland", 35000000);
        Country countryE2 = new Country("Czech Republic", 10000000);
        Country countryE3 = new Country("Germany", 80000000);
        Country countryAf1 = new Country("Nigeria", 200000000);
        Country countryAf2  = new Country("Kongo", 5000000);
        Country countryAf3  = new Country("Gabon", 2000000);
        Country countrySA1 = new Country("Chile", 20000000);
        Country countrySA2  = new Country("Bolivia", 10000000);
        Country countrySA3  = new Country("Peru", 30000000);

        Continent europe = new Continent("Europe");
        Continent africa = new Continent("Africa");
        Continent southAmerica = new Continent("South America");
        europe.addCountry(countryE1);
        europe.addCountry(countryE2);
        europe.addCountry(countryE3);
        africa.addCountry(countryAf1);
        africa.addCountry(countryAf2);
        africa.addCountry(countryAf3);
        southAmerica.addCountry(countrySA1);
        southAmerica.addCountry(countrySA2);
        southAmerica.addCountry(countrySA3);


        //When
        World earth = new World("Earth");
        earth.addContinent(europe);
        earth.addContinent(africa);
        earth.addContinent(southAmerica);
        BigDecimal totalQtyOnEarth = earth.getPeopleQuantity();

        //Then
        BigDecimal expectedQty = new BigDecimal("392000000");
        assertEquals(expectedQty, totalQtyOnEarth);
    }

}
