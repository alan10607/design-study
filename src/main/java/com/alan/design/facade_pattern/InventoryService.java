package com.alan.design.facade_pattern;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {

    public List<Integer> getAvailableProducts(List<Integer> ids) {
        return new ArrayList<>(); // skip detail
    }
}