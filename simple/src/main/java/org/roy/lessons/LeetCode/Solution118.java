package org.roy.lessons.LeetCode;

import java.util.*;
public class Solution118 {

	public List<List<Integer>> generate(int numRows) {
		Vector<List<Integer>> ret = new Vector<List<Integer>>();
		for(int i=0;i<numRows;i++){
			Vector<Integer> curRow = new Vector<Integer>();
			List<Integer> lastRow = null;
			if(i > 0){
				lastRow = ret.get(i-1);
			}
			for(int j=0;j<i+1;j++){
				if(j == 0 || j == i)
					curRow.add(1);
				else{
					curRow.add(lastRow.get(j-1) + lastRow.get(j));
				}
			}
			ret.add(curRow);
		}
		return ret;
	}

	public static void main(String[] args) {
		Solution118 instance = new Solution118();
		List<List<Integer>> ret = instance.generate(20);
		for(List<Integer> row : ret){
			System.out.println();
			for(Integer i:row)
				System.out.print(i+",");
		}
	}
}