package org.roy.lessons.LeetCode;

import java.util.ArrayList;

public class Solution006 {

	public String convert(String s, int nRows) {
		if(nRows == 1) return s; // in case ArrayIndexOutBoundException
		ArrayList<String> als = new ArrayList<String>();
		int ind = -1,tag = 1;
		for(int i=0;i<nRows;i++){
			als.add(new String(""));
		}
		for(int i=0;i<s.length();i++){
			ind += tag;
			String cur = als.get(ind).concat(s.substring(i, i+1));
			als.set(ind, cur);
			if(ind == nRows - 1)
				tag = -1;
			else if(ind == 0){
				tag = 1;
			}
		}
		String ret = "";
		for(int i=0;i<als.size();i++){
			ret = ret.concat(als.get(i));
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Solution006 a = new Solution006();
		System.out.println(a.convert("ab", 1));
	}
}
