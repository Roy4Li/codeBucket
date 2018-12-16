package org.roy.lessons.leetcode;

import java.util.*;
public class Solution165 {

	public int compareVersion(String version1, String version2) {
		String[] asver1 = version1.split("\\.");
		String[] asver2 = version2.split("\\.");
		Vector<String> vsver1 = new Vector<String>();
		Vector<String> vsver2 = new Vector<String>();
		for(String s : asver1)
			vsver1.add(s);
		for(String s:asver2)
			vsver2.add(s);
		int lenVer1 = vsver1.size();
		int lenVer2 = vsver2.size();
		int diff = lenVer1 - lenVer2;
		if(diff >= 0){
			for(int i=0;i<diff;i++)
				vsver2.add("0");
		} else {
			for(int i=0;i<-diff;i++){
				vsver1.add("0");
			}
		}
		int result = 0;
		for (int i=0; i < vsver1.size(); i++) {
			result = compareNum(vsver1.elementAt(i), vsver2.elementAt(i));
			if (result != 0)
				return result;
		}
		return result;
	}

	public int compareNum(String str1, String str2) {
		Integer val1 = Integer.valueOf(str1);
		Integer val2 = Integer.valueOf(str2);
		if(val1 > val2)
			return 1;
		else if(val1 < val2)
			return -1;
		else 
			return 0;
	}

	public static void main(String[] args) {
		Solution165 instance = new Solution165();
		String version1 = "1.0";
		String version2 = "01";
		System.out.println(instance.compareVersion(version1, version2));
	}
}