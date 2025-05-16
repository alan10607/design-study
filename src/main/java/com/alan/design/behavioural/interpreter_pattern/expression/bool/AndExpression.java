package com.alan.design.behavioural.interpreter_pattern.expression.bool;

public class AndExpression implements BooleanExpression {
    private final BooleanExpression left;
    private final BooleanExpression right;

    public AndExpression(BooleanExpression left, BooleanExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Boolean interpret() {
        return left.interpret() && right.interpret();
    }
}
