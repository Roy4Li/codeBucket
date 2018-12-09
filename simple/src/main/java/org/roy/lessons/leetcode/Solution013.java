package org.roy.lessons.leetcode;

public class Solution013 {

	public int romanToInt(String s) {
		char[] ac = s.toCharArray();
		int result = 0;
		char lastChar = 0;
		for(int i=0;i<ac.length;i++){
			switch(ac[i]){
			case  'M':
				if(lastChar == 'C'){ //CM
					result -= 100;
					result += 900;
					lastChar = ac[i];
				} else{
					result += 1000;
					lastChar = ac[i];
				}
			 	break;
			case  'D':
				if(lastChar == 'C'){ // CD
					result -= 100;
					result += 400;
					lastChar = 0;
				} else {
					result += 500;
					lastChar = ac[i];
				}
				break;
			case 'C':
				if(lastChar == 'X'){ // XC
					result -= 10;
					result += 90;
					lastChar = 0;
				} else {
					result += 100;
					lastChar = ac[i];
				}
				break;
			case 'L':
				if(lastChar == 'X'){ // XL
					result -= 10;
					result += 40;
					lastChar = 0;
				} else {
					result += 50;
					lastChar = 0;
				}
				break;
			case 'X' : 
				if(lastChar == 'I'){ // IX
					result -= 1;
					result += 9;
					lastChar = 0;
				} else {
					result += 10;
					lastChar = ac[i];
				}
				break;
			case 'V' :
				if(lastChar == 'I'){ // IV
					result -= 1;
					result += 4;
					lastChar = 0;
				} else {
					result += 5;
					lastChar = ac[i];
				}
				break;
			case 'I' :
				result += 1;
				lastChar = ac[i];
				break;
			default :
				return 0;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "MDCCCLXXXIV";
		Solution013 a = new Solution013();
		System.out.println(a.romanToInt(s));
	}
}
