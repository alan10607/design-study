package com.alan.design.factory_pattern.product;

import com.alan.design.factory_pattern.ProductType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NormalProduct extends Product {

    @Override
    public ProductType getProductType() {
        return ProductType.NORMAL_PRODUCT;
    }
}
