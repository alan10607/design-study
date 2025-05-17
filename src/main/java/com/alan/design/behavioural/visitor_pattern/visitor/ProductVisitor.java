package com.alan.design.behavioural.visitor_pattern.visitor;

import com.alan.design.behavioural.visitor_pattern.product.ClothingProduct;
import com.alan.design.behavioural.visitor_pattern.product.ElectronicProduct;
import com.alan.design.behavioural.visitor_pattern.product.FoodProduct;

public interface ProductVisitor {
    void visit(ClothingProduct clothingProduct);

    void visit(ElectronicProduct electronicProduct);

    void visit(FoodProduct foodProduct);
}
