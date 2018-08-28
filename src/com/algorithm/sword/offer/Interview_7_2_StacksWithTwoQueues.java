package com.algorithm.sword.offer;

import java.util.LinkedList;
import java.util.Queue;

public class Interview_7_2_StacksWithTwoQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        Interview_7_2_StacksWithTwoQueues main = new Interview_7_2_StacksWithTwoQueues();
        main.push(1);
        main.push(2);
        main.push(3);
        System.out.println(main.pop());
        System.out.println(main.pop());
        System.out.println(main.pop());
    }

    public void push(int num) {
        if (!queue1.isEmpty()) {
            queue1.offer(num);
        } else {
            queue2.offer(num);
        }
    }

    public int pop() throws Exception {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new Exception("Stack is empty.");
        }
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        } else {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
    }
}
