package com.bycuimiao.test;

/**
 * @Description TODO
 * @Date 2019/8/31 10:28 上午
 * @Author bycuimiao
 **/
public class Temp02 {
    public static void main(String[] args) {
        //int [] arr = {3,2,1,5,4};
        int [] arr = {4,8,7,2,5,9,1,3,6};
        quickSort(arr,0,arr.length-1);
        for(int i = 0 ; i < arr.length ; i ++){
            System.out.println(arr[i]);
        }
    }

    private static void bubbleSort(int[] arr){
        for(int i = 0 ; i < arr.length ; i ++){
            for(int j = i + 1 ; j < arr.length ; j ++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private static void quickSort(int[] a, int low, int high) {
        if(low >= high){
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
        quickSort(a,i + 1 , high );
    }
}
