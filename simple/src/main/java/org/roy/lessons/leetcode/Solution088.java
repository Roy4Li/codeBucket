package org.roy.lessons.leetcode;

public class Solution088 {

	public void merge(int A[], int m, int B[], int n) {
		int[] temp = new int[m+n];
		int i=0,j=0,k=0; 
		for(;i<m && j<n;k++){
			if(A[i] <= B[j]){
				temp[k] = A[i];
				i++;
			} else {
				temp[k] = B[j];
				j++;
			}
		}
		for(;i<m;i++){
			temp[k] = A[i];
			k++;
		}
		for(;j<n;j++){
			temp[k] = B[j];
			k++;
		}
		for(i=0;i<m+n;i++){
			A[i] = temp[i];
		}
	}

	public static void main(String[] args) {
		Solution088 instance = new Solution088();
		System.out.println();
	}
}