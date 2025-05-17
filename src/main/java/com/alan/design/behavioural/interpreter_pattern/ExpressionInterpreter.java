package com.alan.design.behavioural.interpreter_pattern;

import com.alan.design.behavioural.interpreter_pattern.expression.bool.AndExpression;
import com.alan.design.behavioural.interpreter_pattern.expression.bool.BooleanExpression;
import com.alan.design.behavioural.interpreter_pattern.expression.bool.LeftGtRightExpression;
import com.alan.design.behavioural.interpreter_pattern.expression.bool.LeftLtRightExpression;
import com.alan.design.behavioural.interpreter_pattern.expression.number.ConstantExpression;
import com.alan.design.behavioural.interpreter_pattern.expression.number.NumericExpression;
import com.alan.design.behavioural.interpreter_pattern.expression.number.VariableExpression;

public class ExpressionInterpreter {
    private final String expression;

    public ExpressionInterpreter(String expression) {
        this.expression = expression;
    }

    public BooleanExpression parse(Object context) {
        String[] tokens = tokenize(expression);

        BooleanExpression result = parseComparison(
                parseOperand(tokens[0], context),
                tokens[1],
                parseOperand(tokens[2], context)
        );

        int i = 3;
        while (i < tokens.length) {
            String logicalOp = tokens[i++];
            String left = tokens[i++];
            String comparisonOp = tokens[i++];
            String right = tokens[i++];

            BooleanExpression next = parseComparison(
                    parseOperand(left, context),
                    comparisonOp,
                    parseOperand(right, context)
            );
            result = parseLogical(result, logicalOp, next);
        }

        return result;
    }

    private String[] tokenize(String input) {
        return input.split("\\s+");
    }

    private NumericExpression parseOperand(String token, Object context) {
        if (isNumeric(token)) {
            return new ConstantExpression(token);
        } else {
            return new VariableExpression(context, token);
        }
    }

    private BooleanExpression parseComparison(NumericExpression leftExp, String comparisonOp, NumericExpression rightExp) {
        return switch (comparisonOp) {
            case ">" -> new LeftGtRightExpression(leftExp, rightExp);
            case "<" -> new LeftLtRightExpression(leftExp, rightExp);
            default -> throw new RuntimeException("Unsupported comparison operator:" + comparisonOp);
        };
    }

    private BooleanExpression parseLogical(BooleanExpression leftExp, String logicalOp, BooleanExpression rightExp) {
        return switch (logicalOp) {
            case "&&" -> new AndExpression(leftExp, rightExp);
            default -> throw new RuntimeException("Unsupported logical operator:" + logicalOp);
        };
    }

    private boolean isNumeric(String token) {
        return token.matches("\\d+");
    }
}
