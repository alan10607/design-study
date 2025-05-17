package com.alan.design.behavioural.interpreter_pattern.expression.bool;

import com.alan.design.behavioural.interpreter_pattern.expression.Expression;

public interface BooleanExpression extends Expression { // Non terminal expression
    Boolean interpret();
}
