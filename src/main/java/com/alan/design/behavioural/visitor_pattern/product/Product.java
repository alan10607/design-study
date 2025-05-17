package com.alan.design.behavioural.visitor_pattern.product;

import com.alan.design.behavioural.visitor_pattern.visitor.ProductVisitor;

public interface Product {
    void accept(ProductVisitor visitor);
}
