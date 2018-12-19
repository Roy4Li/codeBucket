package org.roy.lessons.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Level:  Easy
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * {@literal https://leetcode.com/problems/implement-stack-using-queues/}
 */
public class Solution225 {
    private List<Integer> arrayList;

    /**
     * Initialize your data structure here.
     */
    public Solution225() {
        arrayList = new ArrayList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        arrayList.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int size = arrayList.size();
        return arrayList.remove(size - 1);
    }

    /**
     * Get the top element.
     */
    public int top() {
        int size = arrayList.size();
        return arrayList.get(size - 1);
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return arrayList.size() == 0;
    }


    public static void main(String[] args) {
        Solution225 instance = new Solution225();
        instance.push(1);
        instance.push(2);
        instance.push(3);
        instance.top();
        instance.pop();
        instance.empty();
    }
}