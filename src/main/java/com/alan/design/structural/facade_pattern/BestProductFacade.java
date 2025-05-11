package com.alan.design.structural.facade_pattern;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BestProductFacade {
    private final SalesService salesService;
    private final InventoryService inventoryService;
    private final ProductService productService;

    public List<Product> getTopSellingProducts() {
        List<Integer> topSellingIds = salesService.getTopSellingProductIds();
        List<Integer> availableTopSellingIds = inventoryService.getAvailableProducts(topSellingIds);
        return productService.get(availableTopSellingIds);
    }
}