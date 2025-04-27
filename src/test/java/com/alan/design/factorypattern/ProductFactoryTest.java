package com.alan.design.factorypattern;

import com.alan.design.factorypattern.product.NormalProduct;
import com.alan.design.factorypattern.product.Product;
import com.alan.design.factorypattern.product.TaxFreeProduct;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ProductFactoryTest {

    @Test
    void textCreateProduct() {
        Product normalProduct = ProductFactory.createProduct(ProductType.NORMAL_PRODUCT);
        Product taxFreeProduct = ProductFactory.createProduct(ProductType.TAX_FREE_PRODUCT);

        assertTrue(normalProduct instanceof NormalProduct);
        assertEquals(normalProduct.getProductType(), ProductType.NORMAL_PRODUCT);
        assertTrue(taxFreeProduct instanceof TaxFreeProduct);
        assertEquals(taxFreeProduct.getProductType(), ProductType.TAX_FREE_PRODUCT);
    }

}