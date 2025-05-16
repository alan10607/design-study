package com.alan.design.behavioural.iterator_pattern.iterator;

import com.alan.design.behavioural.iterator_pattern.Product;

import java.util.List;

public class RecommendationIterator implements ProductIterator {
    private final List<ProductIterator> iterators;
    private int cur = 0;

    public RecommendationIterator(List<ProductIterator> iterators) {
        this.iterators = iterators;
    }

    @Override
    public boolean hasNext() {
        while (cur < iterators.size()) {
            if (iterators.get(cur).hasNext()) {
                return true;
            } else {
                ++cur;
            }
        }

        return false;
    }

    @Override
    public Product next() {
        if (hasNext()) {
            return iterators.get(cur).next();
        } else {
            return null;
        }
    }
}
