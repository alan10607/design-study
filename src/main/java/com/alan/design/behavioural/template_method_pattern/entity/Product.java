package com.alan.design.behavioural.template_method_pattern.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Product extends CrudEntity {
    private String name;
    private int price;
}
