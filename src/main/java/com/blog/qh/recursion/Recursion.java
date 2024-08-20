package com.blog.qh.recursion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

public class Recursion {


//    反向打印字符串
    public void reverseStr(String str,int index) {
        if(index == str.length()) {
            return;
        }
        reverseStr(str,index+1);
        System.out.println(str.charAt(index));
    }


    /**
     * 打印num的阶乘
     * @param num
     */
    public int factorial(int num) {
        if(num == 1) {
            return 1;
        }
        return num * factorial(num -1);
    }


    /**
     * 递归二分查找
     */

    public int binarySearch(int left,int right,int[] arr,int target)  {
//        int left = 0;
//        int right = arr.length;
        int mid = (left+right) >>> 1; // / 2


        if (left >= right) {
            return -1;
        }

        if(arr[mid] > target) {
            return binarySearch(left,right = mid-1,arr,target);
        } else if (arr[mid] < target) {
            return binarySearch(left=mid+1,right,arr,target);
        } else {
            return mid;
        }

    }


    /**
     * 普通冒泡排序
     */
    public void bubblingSort1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0;j<arr.length-i-1;j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * @param arr 待排序数组
     * @param len 排序的范围
     */
    public void bubblingSort2(int[] arr,int len) {
        if(len == 0) {
            return;
        }
        for (int i = 0; i < len - 1; i++) {
            if(arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
//      上面循环后每次都排序好了一个数，待排序的范围就-1，如果待排序的范围等于0时代表已经整个数组已经排序好了
        bubblingSort2(arr,len-1);
    }





    public static void main(String[] args) {
        Recursion recursion = new Recursion();
//        String str = "Hello-World!";
//        recursion.reverseStr(str,0);
//        System.out.println(recursion.factorial(5));
//        int[] arr= {1,2,4,5,6,7,8,9,10};
//        int left =0;
//        int right = arr.length;
//        int mid = (left+right) >>> 1;
//        System.out.println(recursion.binarySearch(left, right, arr, 10));
//        int[] arr1 = {10,23,100,12,1,3};
//        recursion.bubblingSort1(arr1);
//        System.out.println(Arrays.toString(arr1));
//        recursion.bubblingSort2(arr1,arr1.length);
//        System.out.println(Arrays.toString(arr1));


        Date date = new Date();
        System.out.println(date);




    }


}
