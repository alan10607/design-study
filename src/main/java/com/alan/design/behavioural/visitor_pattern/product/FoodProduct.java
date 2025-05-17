package com.alan.design.behavioural.visitor_pattern.product;

import com.alan.design.behavioural.visitor_pattern.visitor.ProductVisitor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class FoodProduct implements Product {
    private long id;
    private String name;
    private int price;
    private LocalDate expiredDate;

    @Override
    public void accept(ProductVisitor visitor) {
        visitor.visit(this);
    }
}
