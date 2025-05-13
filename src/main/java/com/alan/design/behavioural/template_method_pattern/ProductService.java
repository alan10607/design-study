package com.alan.design.behavioural.template_method_pattern;

import com.alan.design.behavioural.template_method_pattern.entity.Product;
import com.alan.design.behavioural.template_method_pattern.repository.ProductRepository;
import com.alan.design.behavioural.template_method_pattern.repository.Repository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService extends CrudTemplate<Product> {
    private final ProductRepository productRepository;

    @Override
    protected Repository<Product> getRepository() {
        return productRepository;
    }

    @Override
    protected void validate(Product product) {
        if (product.getPrice() < 0) {
            throw new IllegalStateException("Product price should > 0");
        }
    }

    @Override
    protected void beforeCreate(Product entity) {
        // skip detail
    }

    @Override
    protected void afterCreate(Product entity) {
        // skip detail
    }
}
