package org.roy.lessons.temp.AliExam;


import java.util.List;

public class FindTriple {
	
	/**	
	 * 一组整型数中，有一个数字重复3遍，其它数字重复2遍，
	 * 请找出这个重复3遍的数字。
	 * 比如：[88, 459, 5262, 88, -17, 677, 88, 667, -17, 459, 5262], 结果为88。
	 * 要求程序代码中额外申请的空间为O(1)，请给出一个平均时间复杂度不大于O(nlogn)的算法。
	 * 请首先用文字阐述答题思路，然后用Java程序实现。
	 * 思路1：遍历数组，并用map记录下出现的数和位置，下次遇到相同数字，两两删除，最后剩下的就是要找的数
	 * 但是:需要申请O(n)空间，不合符要求。再想！
	 * 思路2：遍历多次，每次遍历时，记录起始值出现次数，直到找到重复3次的值；满足要求，噢耶~
	 */
	public int findTriple(int[] nums){
		for(int i=0;i<nums.length;i++){
			int t=nums[i];
			int cnt = 1;
			for(int j=i;i<nums.length;j++){
				if(nums[j] == t){
					cnt++;
					if(cnt == 3)
						return t;
				}
			}
		}
		// 只要输入符合要求，不会运行到这里
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
