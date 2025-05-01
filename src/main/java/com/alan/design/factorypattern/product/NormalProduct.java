package com.alan.design.factorypattern.product;

import com.alan.design.factorypattern.ProductType;
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
