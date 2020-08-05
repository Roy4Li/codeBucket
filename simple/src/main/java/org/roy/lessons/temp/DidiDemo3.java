package org.roy.lessons.temp;

import com.google.common.collect.Lists;

import java.util.List;

public class DidiDemo3 {
    /**
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），
     * 请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     * 示例 1:  输入: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] 输出: [1,2,3,6,9,8,7,4,5] 示例
     * 2:  输入: [ [1, 2, 3, 4], [5, 6, 7, 8], [9,10,11,12] ]
     * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     */


    public static void main(String[] args) {
        DidiDemo3 instance = new DidiDemo3();
        int[][] twoDimArr = new int[3][3];
        twoDimArr[0] = new int[]{1,2,3};
    }

    public List<Integer> walk(int[][] twoDimArray) {
        List<Integer> retList = Lists.newArrayList();
        int m = twoDimArray.length;
        int n = twoDimArray[0].length;
        // 每loop 1次,范围缩小1,第一次为0
        for (int loop = 0; loop < m / 2 && loop < n / 2; loop++) {
            int i = loop, j = loop;
            // 上面的边:j不变,i递增到 边界
            while (i < m - loop) {
                retList.add(twoDimArray[i++][j]);
            }
            // 此时 i 在边界点
            // 右边的边
            while (j < n - loop){
                retList.add(twoDimArray[i][j++]);
            }
            // 此时 j 在边界点
            // 下面的边,i可以回到起点
            while (i >= loop){
                retList.add(twoDimArray[i--][j]);
            }
            // 此时i=loop,j在边界
            while (j > loop){
                retList.add(twoDimArray[i][j--]);
            }
            // 此时i=loop,j=loop
        }
        return retList;
    }
}
