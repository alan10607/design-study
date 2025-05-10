package com.alan.design.factory_pattern;

import com.alan.design.factory_pattern.product.NormalProduct;
import com.alan.design.factory_pattern.product.Product;
import com.alan.design.factory_pattern.product.TaxFreeProduct;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FactoryPatternTest {

    @Test
    void testCreateProductFactory() {
        Product normalProduct = ProductFactory.createProduct(ProductType.NORMAL_PRODUCT);
        Product taxFreeProduct = ProductFactory.createProduct(ProductType.TAX_FREE_PRODUCT);

        assertTrue(normalProduct instanceof NormalProduct);
        assertEquals(normalProduct.getProductType(), ProductType.NORMAL_PRODUCT);
        assertTrue(taxFreeProduct instanceof TaxFreeProduct);
        assertEquals(taxFreeProduct.getProductType(), ProductType.TAX_FREE_PRODUCT);
    }

}