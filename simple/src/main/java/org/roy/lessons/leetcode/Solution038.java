package org.roy.lessons.leetcode;

public class Solution038 {
	public String countAndSay(int n) {
		String inStr = "1";
		for (int i = 1; i < n; i++) {
			inStr = generateNext(inStr);
		}
		return inStr;
	}

	public String generateNext(String s) {
		String ret = "";
		char[] ac = s.toCharArray();
		Integer count = new Integer(0);
		char last = ac[0];
		for (int i = 0; i < ac.length; i++) {
			if (last != ac[i]) {
				ret = ret.concat(count.toString().concat(
						new Character(last).toString()));
				count = 1;
			} else {
				count++;
			}
			last = ac[i];
		}
		if(count > 0)
			ret = ret.concat(count.toString()).concat(
					new Character(last).toString());
		return ret;
	}

	public static void main(String[] args) {
		Solution038 a = new Solution038();
		System.out.println(a.countAndSay(20));
	}
}
