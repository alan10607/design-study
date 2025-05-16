package com.alan.design.behavioural.interpreter_pattern.expression.number;

import java.lang.reflect.Method;

public class VariableExpression implements NumericExpression {
    private final int value;

    public VariableExpression(Object obj, String fieldName) {
        try {
            String getterName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Method getter = obj.getClass().getMethod(getterName);
            Object value = getter.invoke(obj);
            this.value = ((Number)value).intValue();
        } catch (Exception e) {
            throw new RuntimeException("Extract field failed", e);
        }
    }

    @Override
    public Integer interpret() {
        return value;
    }
}
