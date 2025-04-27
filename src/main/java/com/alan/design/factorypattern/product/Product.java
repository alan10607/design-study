package com.alan.design.factorypattern.product;

import com.alan.design.factorypattern.ProductType;

public abstract class Product {
    private Long id;
    private String name;
    private int price;

    public abstract ProductType getProductType();
}
