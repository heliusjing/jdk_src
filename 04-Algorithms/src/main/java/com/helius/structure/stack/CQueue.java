package com.helius.structure.stack;

import java.util.Stack;

/**
 * @Author jcf
 * @Create 2020-10-26-3:35 下午
 */
public class CQueue {
    Stack<Integer> inputStack;
    Stack<Integer> outputStack;

    public CQueue(Stack<Integer> inputStack, Stack<Integer> outputStack) {
        this.inputStack = inputStack;
        this.outputStack = outputStack;
    }

    public void appendTail(int value) {
        inputStack.push(value);
    }
    //删除操作
    public int deleteHead() {
        if (!outputStack.isEmpty()) {
            return outputStack.pop();
        } else if (!inputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.isEmpty() ? -1 : outputStack.pop();
    }
}
