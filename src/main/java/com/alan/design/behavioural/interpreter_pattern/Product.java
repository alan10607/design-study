package com.alan.design.behavioural.interpreter_pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private long id;
    private String name;
    private int price;
    private int quantity;
}
