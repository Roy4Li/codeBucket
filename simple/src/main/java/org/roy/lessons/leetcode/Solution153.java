package org.roy.lessons.leetcode;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Solution153 {

    public static void main(String[] args) {
        System.out.println(new Solution153().findMin(new int[]{2,3,5,0,1}));
        System.out.println(new Solution153().findMin_v2(new int[]{2,3,5,0,1}));
        System.out.println(new Solution153().findMax(new int[]{2,3,5,0,1}));

    }

    // 遍历思路: 当前值小于前一个
    // 二分查找思路: 中值>右值,向右找,left+1; 中值<右值,(left,mid]查找,最后留下的是right
    public int findMin(int[] nums) {
        int left = 0,right = nums.length-1;

        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] > nums[right])
                left = mid+1;
            else
                right = mid ;
        }
        return nums[right];
    }

    // 二分查找: 若中值>左值,向右找,left+1; 中值<左值,向左找,(left,mid];最后留下right
    public int findMin_v2(int[] nums){

        int left = 0,right = nums.length-1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] > nums[left])
                left = mid + 1;
            else right = mid;
        }
        return nums[right];
    }

    // 若查找最大值,类似思路
    // 若中值>左值 [mid,right]中查找; 中值<左值,[left,mid-1]中找,最后留下left
    public int findMax(int[] nums){
        int left = 0,right = nums.length -1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] > nums[left])
                left = mid;
            else
                right = mid - 1;
        }
        return nums[left];
    }
}
