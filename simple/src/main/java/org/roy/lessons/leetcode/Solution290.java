package org.roy.lessons.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * {@literal https://leetcode.com/problems/word-pattern/}
 */

public class Solution290 {


    public static void main(String[] args) {
        Solution290 instance = new Solution290();
        String pattern1 = "abba";
        String str1 = "dog dog dog dog";
        System.out.println("case1=" + instance.wordPattern(pattern1, str1));
    }

    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> symbolMapping = new HashMap<>();
        Map<String, Character> mappingSymbol = new HashMap<>();

        char[] chars = pattern.toCharArray();
        String[] strs = str.split(" ");
        if (chars.length != strs.length) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            char symbol = chars[i];
            String s = strs[i];
            String existedMapping = symbolMapping.get(symbol);
            Character existedSymbol = mappingSymbol.get(s);
            if (existedMapping != null && existedSymbol != null
                    && existedMapping.equals(s) && existedSymbol.equals(symbol)) {
                continue;
            }
            if (existedMapping == null && existedSymbol == null) {
                symbolMapping.put(symbol, s);
                mappingSymbol.put(s, symbol);
                continue;
            }
            return false;
        }
        return true;
    }
}