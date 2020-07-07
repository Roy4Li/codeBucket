package org.roy.lessons.leetcode;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class Solution33 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 0};
        int result = new Solution33().search(nums, 4);
        System.out.println("result=" + result);
    }

    // 要求是O(logN)
    // 思路: 二分查找法
    // 要注意数组被反转过,要判断是上半部or下半部.判断方法是比较中值与末尾值,若中值<末尾值,则下半部有序,若中值>末尾值,则上半部有序;
    // corner case
    public int search(int[] nums, int target) {
        // O(N)算法是遍历
        // O(logN)算法是二分查找
        int left = 0,right = nums.length-1;
        while (left <= right){
            int middle = (left + right) / 2;
            if(nums[middle] == target){
                return middle;
            }
            int midValue = nums[middle];
            // 处于上半部 or 下半部
            if(midValue < nums[right]){ // 下半部
                if(target > midValue && target <= nums[right])
                    left = middle + 1;
                else right = middle - 1;
            }else { // 上半部
                if(target >= nums[left] && target < midValue)
                    right = middle - 1;
                else left = middle + 1;
            }
        }
        return -1;
    }

}
