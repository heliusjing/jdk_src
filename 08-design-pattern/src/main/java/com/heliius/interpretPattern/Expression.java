package com.heliius.interpretPattern;

import java.util.HashMap;

/**
 * @Author chengfei.jin
 */

public abstract class Expression {
    public abstract int interpreter(HashMap<String,Integer> var);
}
