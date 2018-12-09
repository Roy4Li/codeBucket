package org.roy.lessons.leetcode;


public class Solution014 {

	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0)
			return "";
		String st = strs[0];
		int length = 0;
		for(int i=1;i<strs.length;i++){
			length = lcp(st,strs[i]);
			if(length == 0) 
				return "";
			st = st.substring(0,length);
		}
		return st;
	}
	
	// find the (index + 1) of the end char of the common prefix,0 means null
	public int lcp(String str1,String str2){
		int i = 0;
		for(;i<str1.length() && i<str2.length();i++){
			if(str1.substring(i, i+1).equals(str2.substring(i,i+1)))
				continue;
			else 
				break;
		}
		return i;
	}
	
	public static void main(String[] args) {
		Solution014 a = new Solution014();
		System.out.println();
	}
}
