package com.alan.design.factorypattern.product;

import com.alan.design.factorypattern.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NormalProduct extends Product {

    @Override
    public ProductType getProductType() {
        return ProductType.NORMAL_PRODUCT;
    }
}
