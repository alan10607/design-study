package com.alan.design.behavioural.iterator_pattern.iterator;

import com.alan.design.behavioural.iterator_pattern.Product;

public interface ProductIterator {
    boolean hasNext();

    Product next();
}