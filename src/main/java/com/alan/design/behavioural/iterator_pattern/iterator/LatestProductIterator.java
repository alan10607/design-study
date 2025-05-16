package com.alan.design.behavioural.iterator_pattern.iterator;

import com.alan.design.behavioural.iterator_pattern.Product;

import java.util.Iterator;
import java.util.Set;

public class LatestProductIterator implements ProductIterator {
    private final Iterator<Product> productIterator;

    public LatestProductIterator(Set<Product> products) {
        this.productIterator = products.iterator();
    }

    @Override
    public boolean hasNext() {
        return productIterator.hasNext();
    }

    @Override
    public Product next() {
        return productIterator.next();
    }
}