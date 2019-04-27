package day1;

import java.util.ArrayList;
import java.util.Collections;
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
 *   暴力解法 ： 三层循环穷举所有情况
 *   295 / 313 个通过测试用例
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();   //结果集
        for (int i = 0; i < nums.length-2; ++i){         //三层循环穷举所有情况
            for (int j = i + 1; j < nums.length-1; ++j){
                for (int k = j + 1; k < nums.length; k++){
                    if (nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[k]);
                        if (lists.isEmpty()){            //结果集为空，首次直接添加
                            lists.add(tempList);
                        }else {
                            int m = 0;
                            for (; m < lists.size(); m++){      //遍历结果集，有重复结果则不添加
                                List<Integer> list = lists.get(m);
                                Collections.sort(tempList);
                                Collections.sort(list);
                                if (tempList.get(0).equals(list.get(0)) && tempList.get(1).equals(list.get(1)) && tempList.get(2).equals(list.get(2))){
                                    break;   //如果有重复的结果，直接退出循环
                                }
                            }
                            if (m >= lists.size()){      //如果m > lists.size()说明没有找到重复的结果
                                lists.add(tempList);
                            }
                        }

                    }
                }
            }
        }
        return lists;
    }
}
