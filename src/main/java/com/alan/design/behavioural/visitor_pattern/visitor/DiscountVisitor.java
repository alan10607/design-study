package com.alan.design.behavioural.visitor_pattern.visitor;

import com.alan.design.behavioural.visitor_pattern.product.ClothingProduct;
import com.alan.design.behavioural.visitor_pattern.product.ElectronicProduct;
import com.alan.design.behavioural.visitor_pattern.product.FoodProduct;

public class DiscountVisitor implements ProductVisitor {
    private double discount = 0;

    @Override
    public void visit(ClothingProduct clothingProduct) {
        discount += 40;
    }

    @Override
    public void visit(ElectronicProduct electronicProduct) {
        discount += electronicProduct.getPrice() * 0.1;
    }

    @Override
    public void visit(FoodProduct foodProduct) {
        // No discount for food
    }

    public double getDiscount() {
        return discount;
    }
}
