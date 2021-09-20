package com.example.Algrothim.BFPRT;

/**
 *
 *  2021.09.19 中雨-大雨（中秋假期）
 *  BFPRT 问题（关联，三向切分快排，BFPRT算法，Top-K 问题）
 *
 *  解决的问题（线性时间求 Top-k，最坏情况是 O(n)）
 *
 *  1. 将数组数据划分为 n/5 + (n % 5 != 0 ? 1 : 0) 组，并分别查找其中位数（通过插入排序），返回中位数位置。
 *  2. 将每组的中位数组合成一个中位数分组（即为中位数的中位数）
 *  3. 对中位数的中位数使用 BFPRT 来进行排序（把小于主元素的放在最左边）,(主元指中位数)。
 *  4. 若k > index (主元中位数的位置)，对主元后半部分的数组进行 BFPRT 算法的处理
 *  5. 若k < index (主元中位数的位置)，对主元前半部分的数组进行 BFPRT 算法的处理
 *  6. 最后返回的前 k 个值为有序数组。
 *
 *  算法思路很朴素，其实就是一个不断选择中位数的过程。我们先来证明它的正确性，
 *  我们假设最终选出来的数是x，一个长度为n的数组会产生n/5个分组。
 *  由于我们取的是中位数的中位数，所以在这n/5个分组当中，有一半的中位数小于x，
 *  还有一半大于x。在中位数大于它的分组当中至少有3个元素大于等于它，所以整体而言，
 *  至少有 n/10 * 3 = 0.3n的元素大于等于x，同理也可以证明有30%元素小于等于x。
 *  所以最坏的情况选出来的x是70%位置的数。
 *
 *  Gargantua black hold
 *
 */
public class RequestTopKNum {

    public static int insertSort(int[] arr, int left, int right) {
        int temp;
        int i, j;
        for(i = left + 1;i <= right;i += 1) {
            temp = arr[i];
            j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        return ((right - left) >> 1) + left;
    }

    public static int GetPivotIndex(int array[], int left, int right)
    {
        if (right - left < 5)
            return insertSort(array, left, right);

        int sub_right = left - 1;

        // 每五个作为一组，求出中位数，并把这些中位数全部依次移动到数组左边
        for (int i = left; i + 4 <= right; i += 5)
        {
            int index = insertSort(array, i, i + 4);
            swap(array, ++sub_right, index);
        }

        // 利用 BFPRT 得到这些中位数的中位数下标（即主元下标）
        return BFPRT(array, left, sub_right, ((sub_right - left + 1) >> 1) + 1);
    }

    public static int Partition(int array[], int left, int right, int pivot_index)
    {
        swap(array, pivot_index, right); // 把主元放置于末尾

        int partition_index = left; // 跟踪划分的分界线
        for (int i = left; i < right; i++)
        {
            if (array[i] < array[right])
            {
                swap(array, partition_index++, i); // 比主元小的都放在左侧
            }
        }

        swap(array, partition_index, right); // 最后把主元换回来

        return partition_index;
    }

    public static int BFPRT(int array[], int left, int right, int k)
    {
        int pivot_index = GetPivotIndex(array, left, right); // 得到中位数的中位数下标（即主元下标）
        int partition_index = Partition(array, left, right, pivot_index); // 进行划分，返回划分边界
        int num = partition_index - left + 1;

        if (num == k)
            return partition_index;
        else if (num > k)
            return BFPRT(array, left, partition_index - 1, k);
        else
            // 前 5 个为中位数数组，中间第三个为中位数，如果 k > 3，则须要从第四个数开始进行重新 BFPRT 排序。
            return BFPRT(array, partition_index + 1, right, k - num);
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = { 11,9,10,1,13,8,15,0,16,2,17,5,14,3,6,18,12,7,19,4 };
        int i = BFPRT(arr, 0, arr.length - 1, 3);
        System.out.println(i);
    }

}
