package com.alan.design.creational.prototype_pattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrototypePatternTest {

    @Test
    void testCloneProductPrototype() {
        Product Product1 = new Product(1, "product1", 100);
        Product Product2 = Product1.clone();

        assertEquals(Product1.getId(), 1);
        assertEquals(Product1.getName(), "product1");
        assertEquals(Product1.getPrice(), 100);
        assertEquals(Product2.getId(), 1);
        assertEquals(Product2.getName(), "product1");
        assertEquals(Product2.getPrice(), 100);


        Product2.setId(2);
        Product2.setName("product2");
        Product2.setPrice(200);

        assertEquals(Product1.getId(), 1);
        assertEquals(Product1.getName(), "product1");
        assertEquals(Product1.getPrice(), 100);
        assertEquals(Product2.getId(), 2);
        assertEquals(Product2.getName(), "product2");
        assertEquals(Product2.getPrice(), 200);
    }
}