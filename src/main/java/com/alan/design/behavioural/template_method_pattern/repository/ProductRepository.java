package com.alan.design.behavioural.template_method_pattern.repository;

import com.alan.design.behavioural.template_method_pattern.entity.Product;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductRepository implements Repository<Product> {

    @Override
    public Optional<Product> findById(long id) {
        // skip detail
        return Optional.empty();
    }

    @Override
    public Product save(Product entity) {
        // skip detail
        return null;
    }
}
