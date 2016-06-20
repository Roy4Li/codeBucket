package org.roy.lessons.LeetCode;

public class Solution190 {
	
	// you need treat n as an unsigned value
    public int reverseBits(int n) {
        int m = 0;
        for(int i=0;i<32 && n!=0;i++){
        	if((n & 0x80000000) != 0)
        		m |= (1 << i);
        	n <<= 1;
        }
        return m;
    }
    
	public static void main(String[] args) {
		int inputInt = 1 ;
		Solution190 a  = new Solution190();
		System.out.println(a.reverseBits(inputInt));
	}

}
