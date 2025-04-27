package com.alan.design.factorypattern.product;

import com.alan.design.factorypattern.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxFreeProduct extends Product {
    private int taxPrice;

    @Override
    public ProductType getProductType() {
        return ProductType.TAX_FREE_PRODUCT;
    }
}
