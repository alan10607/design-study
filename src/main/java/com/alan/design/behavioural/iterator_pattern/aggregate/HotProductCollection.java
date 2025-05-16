package com.alan.design.behavioural.iterator_pattern.aggregate;

import com.alan.design.behavioural.iterator_pattern.Product;
import com.alan.design.behavioural.iterator_pattern.iterator.HotProductIterator;

import java.util.ArrayList;
import java.util.List;

public class HotProductCollection implements ProductAggregate {
    private final List<Product> products = new ArrayList<>();

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public HotProductIterator getIterator() {
        return new HotProductIterator(products);
    }
}
