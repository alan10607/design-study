package com.alan.design.behavioural.template_method_pattern;

import com.alan.design.behavioural.template_method_pattern.entity.Product;
import com.alan.design.behavioural.template_method_pattern.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TemplateMethodPatternTest {
    @Spy
    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    void testProductServiceCreate() {
        Product newEntity = createProduct(1L, "test produce", 300);
        when(productRepository.save(any())).thenReturn(newEntity);


        Product result = productService.create(newEntity);


        assertEquals(result.getId(), newEntity.getId());
        assertEquals(result.getName(), newEntity.getName());
        assertEquals(result.getPrice(), newEntity.getPrice());

        // should run template methods
        verify(productService, times(1)).validate(any());
        verify(productService, times(1)).beforeCreate(any());
        verify(productService, times(2)).getRepository();
    }

    private Product createProduct(long id, String name, int price) {
        Product product = new Product(name, price);
        product.setId(id);
        return product;
    }
}