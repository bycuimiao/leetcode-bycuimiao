package com.bycuimiao.test;

/**
 * TODO completion javadoc.
 *
 * @author cuimiao
 * @since 14 March 2019
 */
public class Temp {
	public static void main(String[] args) {
		int [] a = {8,3,2,9,6,5,1,4,7};
		quickSort(a,0,a.length - 1);
		for(int i = 0 ; i < a.length ; i ++){
			System.out.println(a[i]);
		}
	}

	private static void quickSort(int[] a , int low ,int high){
		if(low >= high){
			return;
		}
		int key = a[low];
		int i = low;
		int j = high;
		while (i < j){
			while (a[j] >= key && i<j){
				j --;
			}
			while( a[i] <= key && i<j){
				i ++;
			}
			int temp = a[j];
			a[j] = a[i];
			a[i] = temp;
		}
		int temp = a[i];
		a[i] = key;
		a[low] = temp;
		quickSort(a,low,j-1);
		quickSort(a,j+1,high-1);
	}
}
