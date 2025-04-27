package com.alan.design.factorypattern.product;

import com.alan.design.factorypattern.ProductType;
import lombok.Data;

@Data
public abstract class Product {
    private Long id;
    private String name;
    private int price;

    public abstract ProductType getProductType();
}
