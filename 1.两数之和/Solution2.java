package leetcode;

/**
 *给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */

import java.util.HashMap;

/**
 *利用Hash查找省掉了一次循环，Hash查找时间复杂度O(1),总体时间复杂度O(n)      AC
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer,Integer> map = new HashMap<>();
       for (int i = 0;i < nums.length; ++i){
           if (map.containsKey(nums[i])){
               return new int[]{map.get(nums[i]),i};
           }else {
               map.put(target - nums[i],i);
           }
       }
       return null;
    }
}
