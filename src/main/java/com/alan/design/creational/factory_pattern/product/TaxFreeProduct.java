package com.alan.design.creational.factory_pattern.product;

import com.alan.design.creational.factory_pattern.ProductType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TaxFreeProduct extends Product {

    @Override
    public ProductType getProductType() {
        return ProductType.TAX_FREE_PRODUCT;
    }
}
