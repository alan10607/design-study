package com.alan.design.behavioural.iterator_pattern.aggregate;

import com.alan.design.behavioural.iterator_pattern.Product;
import com.alan.design.behavioural.iterator_pattern.iterator.ProductIterator;

public interface ProductAggregate {
    void add(Product product);

    ProductIterator getIterator();
}