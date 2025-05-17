package com.alan.design.behavioural.visitor_pattern;

import com.alan.design.behavioural.visitor_pattern.product.ClothingProduct;
import com.alan.design.behavioural.visitor_pattern.product.ElectronicProduct;
import com.alan.design.behavioural.visitor_pattern.product.FoodProduct;
import com.alan.design.behavioural.visitor_pattern.product.Product;
import com.alan.design.behavioural.visitor_pattern.visitor.DiscountVisitor;
import com.alan.design.behavioural.visitor_pattern.visitor.ExpirationVisitor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VisitorPatternTest {

    @Test
    void testProductVisitor() {
        ClothingProduct cloth1 = new ClothingProduct(11L, "T shirt", 500);
        ClothingProduct cloth2 = new ClothingProduct(11L, "jacket", 1200);
        ElectronicProduct electronic1 = new ElectronicProduct(21L, "iphone", 35000);
        ElectronicProduct electronic2 = new ElectronicProduct(22L, "keyboard", 1200);
        FoodProduct food1 = new FoodProduct(31L, "chocolate", 40, LocalDate.of(2025, 5, 30));
        FoodProduct food2 = new FoodProduct(32L, "curry rice", 120, LocalDate.of(2025, 5, 17));
        List<Product> products = Arrays.asList(cloth1, cloth2, electronic1, electronic2, food1, food2);

        DiscountVisitor discountVisitor = new DiscountVisitor();
        products.forEach(product -> product.accept(discountVisitor));
        assertEquals(discountVisitor.getDiscount(), (2 * 40) + ((35000 + 1200) * 0.1));


        ExpirationVisitor expirationVisitor = new ExpirationVisitor();
        products.forEach(product -> product.accept(expirationVisitor));
        assertEquals(expirationVisitor.getEarliestExpiredDate(), LocalDate.of(2025, 5, 17));
        assertEquals(expirationVisitor.getExpiringProductCount(), 2);
    }

}