package com.alan.design.creational.factory_pattern.product;

import com.alan.design.creational.factory_pattern.ProductType;
import lombok.Data;

@Data
public abstract class Product {
    private Long id;
    private String name;
    private int price;

    public abstract ProductType getProductType();
}
