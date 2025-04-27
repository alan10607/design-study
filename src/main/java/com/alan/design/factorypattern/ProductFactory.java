package com.alan.design.factorypattern;

import com.alan.design.factorypattern.product.NormalProduct;
import com.alan.design.factorypattern.product.Product;
import com.alan.design.factorypattern.product.TaxFreeProduct;

public class ProductFactory {

    public static Product createProduct(ProductType productType) {
        switch (productType) {
            case NORMAL_PRODUCT:
                return new NormalProduct();
            case TAX_FREE_PRODUCT:
                return new TaxFreeProduct();
            default:
                throw new IllegalStateException("Unknown product type");
        }
    }
}
