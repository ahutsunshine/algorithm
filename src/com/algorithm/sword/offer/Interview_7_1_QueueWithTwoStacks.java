package com.algorithm.sword.offer;

import java.util.Stack;

public class Interview_7_1_QueueWithTwoStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) throws Exception {
        Interview_7_1_QueueWithTwoStacks main = new Interview_7_1_QueueWithTwoStacks();
        main.appendTail(1);
        main.appendTail(2);
        System.out.println(main.deleteHead());
        System.out.println(main.deleteHead());
    }

    public void appendTail(int num) {
        stack1.push(num);
    }

    public int deleteHead() throws Exception {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new Exception("Queue is empty.");
        }
        return stack2.pop();
    }
}
