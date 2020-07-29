package org.roy.lessons.leetcode;

import java.util.*;

public class Solution003 {

    public int lengthOfLongestSubstring(String s) {
		char[] charArr = s.toCharArray();
		int max = 0;
		HashSet<Character> existedInWindow = new HashSet();
		for (int left = 0, right = 0; right < charArr.length; right++) {
			boolean existed = existedInWindow.contains(charArr[right]);
			if (existed) {
				// 则移动左指针,并依次删除
				while (charArr[left] != charArr[right]) {
					left++;
					existedInWindow.remove(charArr[right]);
				}
			}
			// 放入当前
			existedInWindow.add(charArr[right]);
			int currentLength = right - left + 1;
			max = Math.max(max, currentLength);
		}
		return max;
	}

    public static void main(String[] args) {
        System.out.println(new Solution003().lengthOfLongestSubstring("pwwkew"));
    }
}
