package com.donkey.a189;

/**
 * @author: lxc
 * @Date: 2019/11/7 11:07
 * @Description:
 */
public class Solution {

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的 原地 算法。
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        if (k <= 0) {
            return;
        }
        int m = k % nums.length;
        int temp, previous;
        for (int j = 0; j < m; j++) {
            previous = nums[nums.length - 1];
            for (int i = 0; i < nums.length; i++) {
                temp = nums[i];
                nums[i] = previous;
                previous = temp;
            }
        }
    }

    public static void rotate1(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        if (k <= 0) {
            return;
        }
        int m = k % nums.length;
        int temp, previous;
        for (int j = 0; j < m; j++) {
            for (int i = nums.length - 1; i >= 1; i--) {
                temp = nums[i - 1];
                previous = nums[i];
                nums[i] = temp;
                nums[i - 1] = previous;
            }
        }
    }

    public static void rotate2(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        if (k <= 0) {
            return;
        }
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);


    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
//        int[] nums ={1,2,3,4};
        int[] nums = {8, 2, 0, 4, 1, 4};
        rotate2(nums, 3);

    }
}