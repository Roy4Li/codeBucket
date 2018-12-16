package org.roy.lessons.leetcode;

import java.util.*;

public class Solution205 {

	public boolean isIsomorphic(String s, String t) {
		Map<Character,Character> map = new HashMap<Character,Character>();
		Set<Character> set = new HashSet<Character>();
		if(s.length() > 0){
			char[] schars = s.toCharArray();
			char[]	tchars = t.toCharArray();
			for(int i=0;i<s.length();i++){
				char a = schars[i];
				char b = tchars[i];
				if(map.containsKey(a)){
					if(map.get(a) != b) return false;
				} else {
					if(set.contains(b)) return false;
					else{
						map.put(a, b);
						set.add(b);
					}
				}
			}
		}
		return true;
	}
	
	public boolean isIsomorphic2(String s, String t) {
		Map<Character,Character> map1 = new HashMap<Character,Character>(); // map:s -- > t
		Map<Character,Character> map2 = new HashMap<Character,Character>();// map :t -- > s
		if(s.length() > 0){
			char[] schars = s.toCharArray();
			char[] tchars = t.toCharArray();
			for(int i=0;i<s.length();i++){
				char a = schars[i];
				char b = tchars[i];
				if(map1.containsKey(a) && map1.get(a)!=b)
					return false;
				if(map2.containsKey(b) && map2.get(b)!=a)
					return false;
				map1.put(a, b);
				map2.put(b, a);
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(new Solution205().isIsomorphic2("egg", "abb"));
	}
}
