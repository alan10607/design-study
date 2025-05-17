package com.alan.design.behavioural.visitor_pattern.product;

import com.alan.design.behavioural.visitor_pattern.visitor.ProductVisitor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClothingProduct implements Product {
    private long id;
    private String name;
    private int price;

    @Override
    public void accept(ProductVisitor visitor) {
        visitor.visit(this);
    }
}
