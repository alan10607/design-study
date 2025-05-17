package com.alan.design.behavioural.visitor_pattern.visitor;

import com.alan.design.behavioural.visitor_pattern.product.ClothingProduct;
import com.alan.design.behavioural.visitor_pattern.product.ElectronicProduct;
import com.alan.design.behavioural.visitor_pattern.product.FoodProduct;

import java.time.LocalDate;

public class ExpirationVisitor implements ProductVisitor {
    private LocalDate earliestExpiredDate;
    private int expiringProductCount = 0;

    @Override
    public void visit(ClothingProduct clothingProduct) {
        // No expired date for cloth
    }

    @Override
    public void visit(ElectronicProduct electronicProduct) {
        // No expired date for electronic
    }

    @Override
    public void visit(FoodProduct foodProduct) {
        updateEarliestExpiredDate(foodProduct.getExpiredDate());
        ++expiringProductCount;
    }

    private void updateEarliestExpiredDate(LocalDate date) {
        if (earliestExpiredDate == null || earliestExpiredDate.isAfter(date)) {
            earliestExpiredDate = date;
        }
    }

    public LocalDate getEarliestExpiredDate() {
        return earliestExpiredDate;
    }

    public int getExpiringProductCount() {
        return expiringProductCount;
    }
}
