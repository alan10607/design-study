package com.alan.design.facade_pattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FacadePatternTest {
    @InjectMocks
    private BestProductFacade bestProductFacade;

    @Mock
    private SalesService salesService;

    @Mock
    private InventoryService inventoryService;

    @Mock
    private ProductService productService;

    @Test
    void testGetTopSellingProducts() {
        // Arrange
        List<Integer> mockedTopSellingProductId = Arrays.asList(11, 22, 33);
        Map<Integer, Boolean> mockedInStockProducts = Map.of(
                11, true,
                22, false,
                33, true
        );
        Map<Integer, Product> mockedProducts = Map.of(
                11, new Product(11, "product1", 100),
                22, new Product(22, "product1", 200),
                33, new Product(33, "product1", 300)
        );
        when(salesService.getTopSellingProductIds()).thenReturn(mockedTopSellingProductId);
        when(inventoryService.getAvailableProducts(anyList())).thenAnswer(invocation -> {
            List<Integer> ids = invocation.getArgument(0);
            return ids.stream().filter(mockedInStockProducts::get).collect(Collectors.toList());
        });
        when(productService.get(anyList())).thenAnswer(invocation -> {
            List<Integer> ids = invocation.getArgument(0);
            return ids.stream().map(mockedProducts::get).collect(Collectors.toList());
        });


        // Act
        List<Product> topSellingProducts = bestProductFacade.getTopSellingProducts();


        // Assert
        assertEquals(topSellingProducts.size(), 2);
        assertEquals(topSellingProducts.get(0).getId(), 11);
        assertEquals(topSellingProducts.get(1).getId(), 33);
        verify(salesService, times(1)).getTopSellingProductIds();
        verify(inventoryService, times(1)).getAvailableProducts(anyList());
        verify(productService, times(1)).get(anyList());
    }
}