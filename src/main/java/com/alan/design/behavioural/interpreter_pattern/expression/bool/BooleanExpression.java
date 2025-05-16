package com.alan.design.behavioural.interpreter_pattern.expression.bool;

import com.alan.design.behavioural.interpreter_pattern.expression.Expression;

public interface BooleanExpression extends Expression {
    Boolean interpret();
}
