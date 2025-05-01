package com.alan.design.factorypattern.product;

import com.alan.design.factorypattern.ProductType;
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
