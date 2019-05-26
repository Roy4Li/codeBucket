package org.roy.lessons.leetcode;

import java.util.ArrayList;

/**
 * {@literal https://leetcode.com/problems/valid-anagram/}
 */

public class Solution242 {


    public static void main(String[] args) {
        Solution242 instance = new Solution242();
    }

    public boolean isAnagram(String s, String t) {
        // all char in t can be found in s,but only once
        if (s.length() != t.length()) return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        ArrayList<Character> sList = toList(sChars);
        for (char tchar : tChars) {
            if (!sList.contains(tchar)) {
                return false;
            }
            sList.remove(new Character(tchar));
        }
        return true;
    }

    private static ArrayList<Character> toList(char[] arry) {
        ArrayList<Character> list = new ArrayList<>();
        for (char c : arry) {
            list.add(c);
        }
        return list;
    }
}