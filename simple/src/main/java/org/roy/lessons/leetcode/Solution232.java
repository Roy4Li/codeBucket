package org.roy.lessons.leetcode;

import java.util.Stack;

/**
 * {@literal https://leetcode.com/problems/implement-queue-using-stacks/}
 * 思路：stack的逆序,先进先出,push的时候引入辅助stack,实现逆序放入
 */

public class Solution232 {


    public static void main(String[] args) {
        Solution232 instance = new Solution232();
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println("peek1="+queue.peek());
        System.out.println("pop1="+queue.pop());
        System.out.println("pop2="+queue.pop());
        System.out.println("empty="+queue.empty());
    }

    public static class MyQueue {
        Stack<Integer> auxStack;
        Stack<Integer> stack;
        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack = new Stack<>();
            auxStack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            while (!stack.isEmpty()){
                auxStack.push(stack.pop());
            }
            stack.push(x);
            while (!auxStack.isEmpty()){
                stack.push(auxStack.pop());
            }
            // 另一个api stack.insertElementAt(x,0);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
           return stack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return stack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
           return stack.size() == 0;
        }
    }
}