package com.alan.design.behavioural.interpreter_pattern.expression.bool;

import com.alan.design.behavioural.interpreter_pattern.expression.number.NumericExpression;

public class LeftGtRightExpression implements BooleanExpression {
    private final NumericExpression left;
    private final NumericExpression right;

    public LeftGtRightExpression(NumericExpression left, NumericExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Boolean interpret() {
        return left.interpret() > right.interpret();
    }
}
