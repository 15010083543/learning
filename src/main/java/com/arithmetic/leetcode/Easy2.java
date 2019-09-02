package com.arithmetic.leetcode;

/**
 * @author LiuPeng
 * @description 简单算法2
 * @date 2019/3/28
 */
public class Easy2 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println(searchInsert(nums, 5));
        System.out.println(3>>1);
    }

    /*
    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。
示例 1:
输入: [1,3,5,6], 5
输出: 2
示例 2:
输入: [1,3,5,6], 0
输出: 0
    */
    public static int searchInsert(int[] nums, int target) {
        // 1.用折半查找的方法查找
        if (nums.length < 1) return 0;
        int length = nums.length >> 1; // 取数组中间的位置


        return 0;
    }

    // 折半查找
    /*private static int helfSearch(int[] nums, int strat, int end, int target){

    }*/

}
