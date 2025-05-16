package com.alan.design.behavioural.iterator_pattern.iterator;

import com.alan.design.behavioural.iterator_pattern.Product;

import java.util.List;

public class HotProductIterator implements ProductIterator {
    private final List<Product> products;
    private int cur = 0;

    public HotProductIterator(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean hasNext() {
        return cur < products.size();
    }

    @Override
    public Product next() {
        if (hasNext()) {
            return products.get(cur++);
        } else {
            return null;
        }
    }
}