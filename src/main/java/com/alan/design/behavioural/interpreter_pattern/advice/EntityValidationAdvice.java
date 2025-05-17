package com.alan.design.behavioural.interpreter_pattern.advice;

import com.alan.design.behavioural.interpreter_pattern.ExpressionInterpreter;
import com.alan.design.behavioural.interpreter_pattern.expression.bool.BooleanExpression;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EntityValidationAdvice {

    @Before("@annotation(entityValidation)")
    public void execute(JoinPoint joinPoint, EntityValidation entityValidation) {
        Object context = joinPoint.getArgs()[0];
        String expressionStr = entityValidation.value();

        ExpressionInterpreter interpreter = new ExpressionInterpreter(expressionStr);
        BooleanExpression expression = interpreter.parse(context);
        if (!expression.interpret()) {
            throw new IllegalStateException("Validation failed");
        }
    }
}
