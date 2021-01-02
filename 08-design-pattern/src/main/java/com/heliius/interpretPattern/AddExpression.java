package com.heliius.interpretPattern;

import java.util.HashMap;

/**
 * @Author chengfei.jin
 */
public class AddExpression extends SymbolExpression {

    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) + super.left.interpreter(var);
    }
}
