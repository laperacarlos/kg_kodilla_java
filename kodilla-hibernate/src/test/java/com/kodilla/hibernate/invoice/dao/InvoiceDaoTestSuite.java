package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product tomato = new Product("tomato");
        Product onion = new Product("onion");
        Product apple = new Product("apple");

        productDao.save(tomato);
        productDao.save(onion);
        productDao.save(apple);

        Item item1 = new Item(tomato, new BigDecimal(15), 2);
        Item item2 = new Item(onion, new BigDecimal(8), 1 );
        Item item3 = new Item(apple, new BigDecimal(10), 2);
        Item item4 = new Item(tomato, new BigDecimal(15), 3);
        Item item5 = new Item(onion, new BigDecimal(8), 3 );

        tomato.getItemList().addAll(Arrays.asList(item1, item4));
        onion.getItemList().addAll(Arrays.asList(item2, item5));
        apple.getItemList().add(item3);

        List<Item> listToInvoice1 = new ArrayList<>(Arrays.asList(item1, item2));
        List<Item> listToInvoice2 = new ArrayList<>(Arrays.asList(item3, item4, item5));

        Invoice invoice1 = new Invoice("666", listToInvoice1);
        Invoice invoice2 = new Invoice("777", listToInvoice2);

        item1.setInvoice(invoice1);
        item2.setInvoice(invoice1);
        item3.setInvoice(invoice2);
        item4.setInvoice(invoice2);
        item5.setInvoice(invoice2);

        //When
        invoiceDao.save(invoice1);
        int invoice1Id = invoice1.getId();
        invoiceDao.save(invoice2);
        int invoice2Id = invoice2.getId();

        //Then
        assertNotEquals(0, invoice1Id);
        assertNotEquals(0, invoice2Id);
        assertEquals(2, invoice1.getItems().size());
        assertEquals(3, invoice2.getItems().size());


        //CleanUp
        try {
            invoiceDao.deleteAll();
            productDao.deleteAll();
        } catch (Exception e) {
            //do nothing
        }
    }
}
