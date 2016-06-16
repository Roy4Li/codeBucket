/**
 * 
 */
package org.roy.lessons.LeetCode;

/**
 * @author Administrator
 * 
 */
public class Solution008 {

	public int atoi(String str) {
		int sign = 1,num=0,i=0;
		char[] ac = str.trim().toCharArray();
		
		if(ac.length == 0) return 0;
		if(ac[0] == '+'){
			i++;
		} else if(ac[0] == '-'){
			sign = -1;
			i++;
		} 
		while(i < ac.length && ac[i] == '0') i++;
		for(;i<ac.length;i++){
			if(ac[i] < '0' || ac[i] >'9'){
				break;
			}
			if(num > Integer.MAX_VALUE / 10 || 
					(num == Integer.MAX_VALUE / 10 && ac[i]-'0' >Integer.MAX_VALUE % 10))
				return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			num = num * 10 + ac[i] - '0';
		}
		return sign * num;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "    +3";
		Solution008 a = new Solution008();
//		a.atoi("  +03abc3");
//		System.out.println(str.matches(" *[\\+\\-]?[0-9]+.*"));
		System.out.println(a.atoi(""));
	}

}
