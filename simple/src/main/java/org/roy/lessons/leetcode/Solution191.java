package org.roy.lessons.leetcode;

public class Solution191 {
	
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	int count = 0;
    	while(n != 0){
    		if((n  & 0x80000000) != 0) count++;
    		n <<= 1;
    	}
    	return count;
    }
    
	public static void main(String[] args) {
//		int inputInt = 2147483648 ;
		// TODO Auto-generated method stub
		Solution191 a  = new Solution191();
		System.out.println(a.hammingWeight(-3));
	}
}
