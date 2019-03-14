package com.bycuimiao.simple;

import java.util.Arrays;

/**
 * TODO completion javadoc.
 *
 * @author cuimiao
 * @since 12 March 2019
 */
public class SortBox {
	public static void main(String[] args) {
		//int[] arr = {6, 3, 1, 4, 5, 8, 7, 9, 2};
		int [] arr = {8,3,2,9,6,5,1,4,7};
		//bubblingSort(arr);
		quickSort(arr, 0, arr.length - 1);
		//quickSortOnline(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		//Arrays.sort(arr);
	}

	/**
	 * 冒泡排序
	 * @param arr
	 */
	private static void bubblingSort(int[] arr) {
		int t;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
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
	public static void quickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		//选择基准
		int key = arr[left];
		//数组中比key小的放在左边，比key大的放在右边，key值下标为i
		int low = left;
		int high = right;
		while (low < high) {
			//high向左移，直到遇到比key小的值
			while (arr[high] >= key && low < high) {
				high--;
			}
			//low向右移，直到遇到比key大的值
			while (arr[low] <= key && low < high) {
				low++;
			}
			//high和low指向的元素交换
			if (low < high) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
		}
		arr[left] = arr[low];
		arr[low] = key;

		quickSort(arr, left, low - 1);
		quickSort(arr,  low + 1, right);

	}

	/**
	 * 经典快排伪代码
	 * @param array
	 * @param left
	 * @param right
	 */
	void quickSortByPseudocode(int array[], int left, int right) {
		//Do nothing if left <= right
		//p <- Get a number from array
		//Put elements <= p to the left side
		//Put elements >= p to the right side
		//Put p in the middle slot which index is pivot
		//Recursive quicksort the left parts and right parts
	}
}
