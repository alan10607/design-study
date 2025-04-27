package com.alan.design.factorypattern.product;

import com.alan.design.factorypattern.ProductType;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public abstract class Product {
    private Long id;
    private String name;
    private int price;

    public abstract ProductType getProductType();
}
