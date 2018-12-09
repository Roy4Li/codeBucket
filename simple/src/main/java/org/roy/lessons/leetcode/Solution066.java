package org.roy.lessons.leetcode;

public class Solution066 {

	public String addBinary(String a, String b) {
		int lengthA = a.length();
		int lengthB = b.length();
		if(lengthA < lengthB)
			return addBinary(b,a);
		// lengthA >= lengthB
		for(int i=lengthA-lengthB;i > 0;i--){
			b = "0" + b;
		}
		char[] aca = a.toCharArray();
		char[] acb = b.toCharArray();
		int carry = 0;
		for(int i=aca.length - 1;i>=0;i--){
			int sum = aca[i]-'0' + acb[i] - '0' + carry;
			switch(sum){
			case 0 : 
				aca[i] = '0';
				break;
			case 1 : 
				aca[i] = '1';
				carry = 0;
				break;
			case 2:
				aca[i] = '0';
				carry = 1;
				break;
			case 3 :
				aca[i] = '1';
				carry = 1;
				break;
			}
		}
		String ret = "";
		if(carry > 0){ // Most Significant bit  carries
			ret += "1";
		}
		ret += String.valueOf(aca);
		return ret;
	}

	public static void main(String[] args) {
		Solution066 instance = new Solution066();
		String ret = instance.addBinary("010", "010");
		System.out.println(ret);
	}
}
