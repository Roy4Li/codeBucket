/**
 * 
 */
package org.roy.lessons.LeetCode;

/**
 * @author Administrator
 * 
 */
public class Solution009 {
	
	/*	
	 * caution:a negative integer cannot be a palindrome 
	 */
	public boolean isPalindrome(int x) {
		boolean result = true;
		if(x < 0)
			return false;
		x = Math.abs(x);
		char[] str = Integer.toString(x).toCharArray();
		for(int i=0;i<str.length / 2;i++){
			if(str[i] != str[str.length-1-i]){
				result = false;
				break;
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 3455433;
		Solution009 a = new Solution009();
		System.out.println(a.isPalindrome(i));
	}
}
