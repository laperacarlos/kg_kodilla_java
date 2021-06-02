package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class TaxiOrderTestSuite {

    @Test
    public void testBasicTaxiOrderGetCost() {
        //given
        TaxiOrder theOrder = new BasicTaxiOrder();
        //when
        BigDecimal calculatedCost = theOrder.getCost();
        //then
        assertEquals(new BigDecimal(5), calculatedCost);
    }

    @Test
    public void testBasicTaxiOrderGetDescription() {
        //given
        TaxiOrder theOrder = new BasicTaxiOrder();
        //when
       String description = theOrder.getDescription();
        //then
        assertEquals("Drive a course", description);
    }

    @Test
    public void testTaxiNetworkOrderGetDescription() {
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);
        //when
        String description = taxiOrder.getDescription();
        //then
        assertEquals("Drive a course by Taxi Network", description);
    }

    @Test
    public void testTaxiNetworkOrderGetCost() {
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);
        //when
        BigDecimal cost = taxiOrder.getCost();
        //then
        assertEquals(new BigDecimal(40), cost);
    }

    @Test
    public void testMyTaxiNetworkOrderWithChildSeatGetDescription() {
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        //when
        String description = taxiOrder.getDescription();
        //then
        assertEquals("Drive a course by MyTaxi Network + child seat", description);
    }

    @Test
    public void testMyTaxiNetworkOrderWithChildSeatGetCost() {
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        //when
        BigDecimal cost = taxiOrder.getCost();
        //then
        assertEquals(new BigDecimal(37), cost);
    }

    @Test
    public void testUberWithTwoChildSeatsGetCost() {
        //given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        //when
        BigDecimal theCost = theOrder.getCost();
        //then
        assertEquals(new BigDecimal(29), theCost);
    }

    @Test
    public void testUberWithTwoChildSeatsGetDescription() {
        //given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        //when
        String description = theOrder.getDescription();
        //then
        assertEquals("Drive a course by Uber Network + child seat + child seat", description);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetCost() {
        //given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new ExpressDecorator(theOrder);
        theOrder = new VipCarDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        //when
        BigDecimal theCost = theOrder.getCost();
        //then
        assertEquals(new BigDecimal(57), theCost);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription() {
        //given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new ExpressDecorator(theOrder);
        theOrder = new VipCarDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        //when
        String description = theOrder.getDescription();
        //then
        assertEquals("Drive a course by Taxi Network express service variant VIP + child seat", description);
    }
}
