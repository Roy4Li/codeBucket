package org.roy.lessons.LeetCode;

import java.util.HashMap;


public class Solution036 {

	public boolean isValidSudoku(char[][] board) {
		for(int i=0;i<9;i++){
			HashMap<Character,Integer> row = new HashMap<Character,Integer>();
			HashMap<Character,Integer> column = new HashMap<Character,Integer>();
			HashMap<Character,Integer> block = new HashMap<Character,Integer>();
			for(int j=0;j<9;j++){
				if(board[i][j] != '.'){
					if(row.containsKey(board[i][j]))
						return false;
					else
						row.put(board[i][j], 1);
				}
				
				if(board[j][i] != '.'){
					if(column.containsKey(board[j][i]))
						return false;
					else
						column.put(board[j][i], 1);
				}
				
				if(board[i/3*3+j/3][i%3*3+j%3] != '.'){
					if(block.containsKey(board[i/3*3+j/2][i%3*3+j%3]))
						return false;
					else
						block.put(board[i/3*3+j/2][i%3*3+j%3], 1);
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution036 a = new Solution036();
		System.out.println();
	}
}
