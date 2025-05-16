package com.alan.design.behavioural.interpreter_pattern;

import com.alan.design.behavioural.interpreter_pattern.expression.bool.AndExpression;
import com.alan.design.behavioural.interpreter_pattern.expression.bool.BooleanExpression;
import com.alan.design.behavioural.interpreter_pattern.expression.bool.LeftGtRightExpression;
import com.alan.design.behavioural.interpreter_pattern.expression.bool.LeftLtRightExpression;
import com.alan.design.behavioural.interpreter_pattern.expression.number.ConstantExpression;
import com.alan.design.behavioural.interpreter_pattern.expression.number.NumericExpression;
import com.alan.design.behavioural.interpreter_pattern.expression.number.VariableExpression;

public class ExpressionInterpreter {
    private Object obj;

    public BooleanExpression parse(String input, Object obj) {
        String[] tokens = tokenize(input);
        BooleanExpression result = null;
        int i = 0;
        while (i < tokens.length) {
            String left = tokens[i++];
            String operator = tokens[i++];
            String right = tokens[i++];

            NumericExpression leftExp = mapLeftOrRight(left);
            NumericExpression rightExp = mapLeftOrRight(right);
            BooleanExpression operatorExp = mapOperator(operator, leftExp, rightExp);

            if (result == null) {
                result = operatorExp;
            } else if(i + 1 < tokens.length){
                String right = tokens[i++];

                result = mapAndOr(tokens[i + 3], tmp, operator);
            }

        }

        return tmp;

    }

    private String[] tokenize(String input) {
        return input.split("\\s+");
    }

    private NumericExpression mapLeftOrRight(String token) {
        if (isNumeric(token)) {
            return new ConstantExpression(token);
        } else {
            return new VariableExpression(obj, token);
        }
    }

    private BooleanExpression mapOperator(String token, NumericExpression left, NumericExpression right) {
        return switch (token) {
            case ">" -> new LeftGtRightExpression(left, right);
            case "<" -> new LeftLtRightExpression(left, right);
            default -> throw new RuntimeException("Unsupported operator");
        };
    }

    private BooleanExpression mapAndOr(String token, BooleanExpression left, BooleanExpression right) {
        return switch (token) {
            case "&&" -> new AndExpression(left, right);
            default -> throw new RuntimeException("Unsupported operator");
        };
    }

    private boolean isNumeric(String token) {
        return token.matches("\\d+");
    }
}
