package com.alan.design.facade_pattern;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalesService {

    public List<Integer> getTopSellingProductIds() {
        return new ArrayList<>(); // skip detail
    }
}