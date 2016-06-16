package org.roy.lessons.LeetCode;

public class Solution031 {

	public void nextPermutation(int[] nums) {
		int length = nums.length;
		int i,j,k;
		for(i=length-1;i>0;i--){
			if(nums[i] > nums[i-1]){
				j = 1;
				while(((i+j)<length) && (nums[i-1]<nums[i+j] ))
					j++;
				// swap 
				int tmp = nums[i-1];
				nums[i-1] = nums[i+j-1];
				nums[i+j-1] = tmp;
				break;
			}
		}
		 // reverse 
		for(k=0;k<(length-i)/2;k++){
			int tmp = nums[i+k];
			nums[i+k] = nums[length-1-k];
			nums[length-1-k] = tmp;
		}
	}

	public static void main(String[] args) {
		int[] nums = {1,3,4,5,6,7};
		new Solution031().nextPermutation(nums);
		for(int i:nums){
			System.out.print(i+",");
		}
	}
}