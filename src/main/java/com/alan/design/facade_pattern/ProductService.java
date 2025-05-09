package com.alan.design.facade_pattern;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public List<Product> get(List<Integer> ids) {
        return new ArrayList<>(); //skip detail
    }
}