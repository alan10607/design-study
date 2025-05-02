package com.alan.design.factory_pattern;

import com.alan.design.factory_pattern.product.NormalProduct;
import com.alan.design.factory_pattern.product.Product;
import com.alan.design.factory_pattern.product.TaxFreeProduct;

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
