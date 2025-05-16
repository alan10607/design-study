package com.alan.design.behavioural.interpreter_pattern.expression.number;

import com.alan.design.behavioural.interpreter_pattern.expression.Expression;

public interface NumericExpression extends Expression {
    Integer interpret();
}
