package com.bycuimiao.simple;

/**
 * TODO completion javadoc.
 *
 * @author cuimiao
 * @since 12 March 2019
 */
public class SortBox {
	public static void main(String[] args) {
		int [] arr = {2,3,1,4,5,8,7,9,6};
		//bubblingSort(arr);
		quicklySort(arr,0,arr.length-1);
		for(int i = 0 ; i < arr.length ; i ++){
			System.out.println(arr[i]);
		}
	}

	/**
	 * 冒泡排序
	 * @param arr
	 */
	private static void bubblingSort(int [] arr){
		int t;
		for(int i = 0 ; i < arr.length ; i ++){
			for (int j = i + 1 ; j < arr.length ; j ++){
				if(arr[i] > arr[j]){
					t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
				}
			}
		}
	}

	/**
	 * 快速排序
	 * @param
	 */
	public static void quicklySort(int[] a,int low,int high){

	}
}
