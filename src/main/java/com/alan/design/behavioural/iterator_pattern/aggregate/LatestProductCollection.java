package com.alan.design.behavioural.iterator_pattern.aggregate;

import com.alan.design.behavioural.iterator_pattern.Product;
import com.alan.design.behavioural.iterator_pattern.iterator.LatestProductIterator;

import java.util.LinkedHashSet;
import java.util.Set;

public class LatestProductCollection implements ProductAggregate {
    private final Set<Product> products = new LinkedHashSet<>();

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public LatestProductIterator getIterator() {
        return new LatestProductIterator(products);
    }
}