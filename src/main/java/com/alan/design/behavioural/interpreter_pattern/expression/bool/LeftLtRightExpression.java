package com.alan.design.behavioural.interpreter_pattern.expression.bool;

import com.alan.design.behavioural.interpreter_pattern.expression.Expression;
import com.alan.design.behavioural.interpreter_pattern.expression.number.NumericExpression;

public class LeftLtRightExpression implements BooleanExpression {
    private final NumericExpression left;
    private final NumericExpression right;

    public LeftLtRightExpression(NumericExpression left, NumericExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Boolean interpret() {
        return left.interpret() < right.interpret();
    }
}
