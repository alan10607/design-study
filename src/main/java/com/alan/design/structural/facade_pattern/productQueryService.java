package com.alan.design.structural.facade_pattern;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class productQueryService {

    public List<Product> get(List<Integer> ids) {
        return new ArrayList<>(); //skip detail
    }
}