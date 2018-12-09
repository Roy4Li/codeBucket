package org.roy.lessons.leetcode;

public class Solution011 {

	public int maxArea1(int[] height) {
		int maxArea = 0;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int area = (j - i) * (Math.min(height[i], height[j]));
				maxArea = Math.max(maxArea, area);
			}
		}
		return maxArea;
	}

	public int maxArea2(int[] height) {
		int left = 0, right = height.length - 1;
		int leftWall = height[left];
		int rightWall = height[right];
		int ret = 0;
		while (left < right) {
			ret = Math.max(ret, (right - left)
					* (Math.min(leftWall, rightWall)));
			if(leftWall < rightWall){
				left++;
				leftWall = height[left];
			} else {
				right--;
				rightWall = height[right];
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int size = 30000000;
		int[] height = new int[size];
		for (int i = 0; i < size; i++)
			height[i] = i + 1;
		System.out.println(new Solution011().maxArea2(height));
	}
}
