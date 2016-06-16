package org.roy.lessons.LeetCode;

public class Solution070 {
	public int climbStairs(int n) {
		int step1 = 1;
		int step2 = 1;
		for(int i=2;i<=n;i++){
			int nextStep = step1 + step2;
			step1 = step2;
			step2 = nextStep;
		}
		return step2;
	}

	public static void main(String[] args) {
		Solution070 instance = new Solution070();
		System.out.println(instance.climbStairs(44));
	}
}
