package leetcode;

/**
 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 你可以假设 nums1 和 nums2 不会同时为空。

 示例 1:
 nums1 = [1, 3]
 nums2 = [2]

 则中位数是 2.0

 示例 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 则中位数是 (2 + 3)/2 = 2.5
 */

import java.util.Arrays;

/**
 *思路：有点类似归并排序中，合并两个有序数组的步骤。合并两个数组后再取中位数     AC
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int mid = total >> 1;
        int i = 0, j = 0, k = 0;
        int[] nums = new int[total];
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] <= nums2[j]){
                nums[k++] = nums1[i++];
            }else {
                nums[k++] = nums2[j++];
            }
        }
        while (i < nums1.length){
            nums[k++] = nums1[i++];
        }
        while (j < nums2.length){
            nums[k++] = nums2[j++];
        }
        if (total % 2 == 0){
            return (nums[mid - 1] + nums[mid]) / 2.0;       //除以2.0，整形转换成浮点型
        }else {
            return nums[mid];
        }
    }
}
