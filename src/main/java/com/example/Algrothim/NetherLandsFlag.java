package com.example.Algrothim;

import java.util.Arrays;

/**
 *
 *  2021.09.19 中雨-大雨（中秋假期）
 *  荷兰国旗问题（关联，三向切分快排，BFPRT算法，Top-K 问题）
 *
 *  解决的问题（给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，
 *  等于num的数放在数组的中间，大于num的数放在数组的右边。）
 *
 *  Gargantua black hold
 *
 */
public class NetherLandsFlag {

    public static int[] partition(int[] arr,int left,int right,int target) {
        //  小于 target 的区域
        int less = left - 1;
        //  大于 target 的区域
        int more = right + 1;
        while (left < more) {
            if (arr[left] < target)
                //＜区扩张，当前值增加
                swap(arr,++less,left++);
            else if (arr[left] > target)
                //大于区缩小，交换，当前值不变
                swap(arr,--more,left);
            else
                left++;
        }
        int[] res = {less + 1, more - 1};
        // 返回相等区域的左右边界。
        return res;
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[j] ^ arr[i];
        arr[i] = arr[j] ^ arr[i];
    }

    public static void main(String[] args) {
        int[] arr = {5,11,6,7,18,12,9};
        int[] res = partition(arr, 0, arr.length - 1, 7);
        System.out.println(res);
//        Arrays.stream(arr).forEach(System.out::print);
    }

}
