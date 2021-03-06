package leetcode;

/**
 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。

 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。

 示例：
 输入：[[10,20],[30,200],[400,50],[30,20]]
 输出：110
 解释：
 第一个人去 A 市，费用为 10。
 第二个人去 A 市，费用为 30。
 第三个人去 B 市，费用为 50。
 第四个人去 B 市，费用为 20。

 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。

 提示：
 1 <= costs.length <= 100
 costs.length 为偶数
 1 <= costs[i][0], costs[i][1] <= 1000
 */


import java.util.Arrays;
import java.util.Comparator;

/**
 *思路：贪心算法,优先分配 |costs[i][0]-costs[i][1]| 大的人，这样就可以将额外的费用降到最低。
 */
public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return -(Math.abs(o1[0] - o1[1]) - Math.abs(o2[0] - o2[1]));
            }
        });
        int ans = 0;
        int acount = 0;
        int bcount = 0;
        for (int i =0; i < costs.length; ++i){
            if (acount < costs.length/2 && bcount < costs.length/2){
                if (costs[i][0] < costs[i][1]){
                    ans += costs[i][0];
                    ++acount;
                } else {
                    ans += costs[i][1];
                    ++bcount;
                }
            }else if (acount == costs.length/2){
                ans += costs[i][1];
            }else {
                ans += costs[i][0];
            }
        }
        return ans;
    }
}