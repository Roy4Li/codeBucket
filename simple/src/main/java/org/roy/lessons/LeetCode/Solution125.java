package org.roy.lessons.LeetCode;

public class Solution125 {

	public boolean isPalindrome(String s) {
		if(s == null || s.length() == 0)
			return true;
		
		char[] ac = s.toLowerCase().toCharArray();
		int i=0,j=ac.length-1;
		while(i<j){
			if(!isAlphaNumberic(ac[i])){
				i++;
				continue;
			}
			if(!isAlphaNumberic(ac[j])){
				j--;
				continue;
			}
			if(ac[i] != ac[j])
				return false;
			i++;
			j--;
		}
		return true;
	}
	
	public boolean isAlphaNumberic(char c){
		return Character.isAlphabetic(c) || Character.isDigit(c);
	}
	

	public static void main(String[] args) {
		Solution125 instance = new Solution125();
		String str = "";
		System.out.println(instance.isPalindrome(str));
	}
}