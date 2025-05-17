package com.alan.design.behavioural.interpreter_pattern;

import com.alan.design.behavioural.interpreter_pattern.advice.EntityValidation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Import(InterpreterPatternTest.EntityValidationTester.class)
class InterpreterPatternTest {
    @Autowired
    EntityValidationTester entityValidationTester;

    @Test
    void testEntityValidation() {
        Product product1 = new Product(1L, "product1", 100, 50);
        Product product2 = new Product(1L, "product1", -100, 50);
        Product product3 = new Product(1L, "product1", 100, 500);

        assertDoesNotThrow(() -> entityValidationTester.testPriceGreaterThan0AndQuantityLessThan100(product1));
        assertThrows(IllegalStateException.class,
                () -> entityValidationTester.testPriceGreaterThan0AndQuantityLessThan100(product2),
                "Validation failed");
        assertThrows(IllegalStateException.class,
                () -> entityValidationTester.testPriceGreaterThan0AndQuantityLessThan100(product3),
                "Validation failed");

    }

    public static class EntityValidationTester {
        @EntityValidation("price > 0 && quantity < 100")
        public void testPriceGreaterThan0AndQuantityLessThan100(Product product) {
        }

    }

}