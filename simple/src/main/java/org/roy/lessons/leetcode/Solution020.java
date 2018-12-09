package org.roy.lessons.leetcode;

import java.util.Stack;

public class Solution020 {

	public boolean isValid(String s) {
		Stack<Character> sc = new Stack<Character>();
		char[] ac = s.toCharArray();
		for (int i = 0; i < ac.length; i++) {
			if ((sc.isEmpty() == false) && isPair(sc.peek(),ac[i]))
				sc.pop();
			else
				sc.push(ac[i]);
		}
		return sc.isEmpty();
	}

	public boolean isPair(Character first,Character last){
		return ((first == '(' && last == ')')
				|| (first == '[' && last == ']')
				|| (first == '{' && last == '}')
				);
	}

	public static void main(String[] args) {
		String inputStr = "[";
		Solution020 a = new Solution020();
		System.out.println(a.isValid(inputStr));
	}

}
