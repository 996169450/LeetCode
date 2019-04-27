package day1.LeetCode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */

/**
 *首先对数组从小到大排序，从一个数开始遍历，若该数大于0，后面的数不可能与其相加和为0，所以跳过；否则该数可能是满足要求的第一个数，
 * 这样可以转化为求后面数组中两数之和为该数的相反数的问题。定义两个指针一前一后，若找到两数之和满足条件则加入到解集中；
 * 若大于和则后指针向前移动，反之则前指针向后移动，直到前指针大于等于后指针。这样遍历第一个数直到数组的倒数第3位。
 * 注意再求和过程中首先判断该数字是否与前面数字重复，保证解集中没有重复解。
 */
public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();   //结果集
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; ++i){
            if (i ==0 || (i > 0 && nums[i] != nums[i-1])){    //如果是相同的数字，可以跳过，跳过重复解
                if (nums[i] > 0){  //因为已经排过序了。如果第一个数就大于0了。那么后面的数肯定是大于0的，那么加起来肯定不会等于0
                    continue;
                }
                int cur = nums[i];
                int start = i + 1;
                int end = nums.length-1;
                while (start < end) {
                    int sum = cur + nums[start] + nums[end];
                    if (sum == 0){
                        lists.add(Arrays.asList(cur, nums[start], nums[end]));
                        ++start;
                        --end;
                        while (start < end && nums[start] == nums[start-1]){   //跳过重复解
                            ++start;
                        }
                        while (start < end && nums[end] == nums[end+1]){      //跳过重复解
                            --end;
                        }
                    }else if (sum > 0){
                        --end;
                    }else {
                        ++start;
                    }

                }
            }
        }
        return lists;
    }
}
