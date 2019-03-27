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
        int[] arr = {8, 3, 2, 9, 6, 5, 1, 4, 7};
        //bubblingSort(arr);
        //quickSort(arr, 0, arr.length - 1);
        heapSort(arr);
        //quickSortOnline(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        //Arrays.sort(arr);
    }

    /**
     * 冒泡排序
     *
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
     * 快速排序 logN
     *
     * @param
     */
    private static void quickSort(int[] a, int low, int high) {
		/*while(low >= high){
			return;
		}
		int key = a[low];
		int i = low;
		int j = high;
		while(i < j){
			while (a[j] >= key && i < j){
				j --;
			}
			while (a[i] <= key && i < j ){
				i ++;
			}
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;

		}
		a[low] = a[i];
		a[i] = key;
		quickSort(a,low , i - 1 );
		quickSort(a,i + 1 , high );*/
    }

    /**
     * 经典快排伪代码
     *
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


    /**
     * 堆排序 nlogn
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     *
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    /**
     * 交换元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
