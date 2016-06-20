package org.roy.lessons.LeetCode;

import java.util.*;

public class Solution155 {
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
	public void push(int x) {
		stack.push(x);
		if(minStack.isEmpty() || x <= minStack.peek().intValue())
			minStack.push(x);
	}

	public void pop() {
		if(minStack.peek().intValue() == stack.pop().intValue())
			minStack.pop();
	}

	public int top() {
		return stack.peek().intValue();
	}

	public int getMin() {
		return minStack.peek().intValue();
	}

	public static void main(String[] args) {
		Solution155 instance = new Solution155();
		instance.push(512);
		instance.push(-1024);
		instance.push(-1024);
		instance.push(512);
		instance.pop();
		System.out.println(instance.getMin());
		instance.pop();
		System.out.println(instance.getMin());
		instance.pop();
		System.out.println(instance.getMin());
	}
}