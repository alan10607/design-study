package com.alan.design.behavioural.interpreter_pattern.expression.number;

public class ConstantExpression implements NumericExpression {
    private final int value;

    public ConstantExpression(String value) {
        this.value = Integer.parseInt(value);
    }

    @Override
    public Integer interpret() {
        return value;
    }
}
