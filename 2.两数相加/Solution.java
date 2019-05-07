package leetcode;

/**
 *给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 *
 * class ListNode {
 *      int val;
 *      ListNode next;
 *      ListNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
import java.util.List;

/**
 *简单思路：分别遍历两个链表，把链表中的数取出来放到List里面，然后做加法（要考虑进位情况），位数结果保存到List，最后构建结果链表    时间复杂度O(n)或者O(m)  AC
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        while (l1 != null){
            list1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            list2.add(l2.val);
            l2 = l2.next;
        }
        int carrybit = 0;  //进位
        while (!list1.isEmpty() && !list2.isEmpty()){
            int sum = list1.remove(0) + list2.remove(0) + carrybit;
            if (sum > 9){
                int remainder = sum % 10;  //余数
                carrybit = sum / 10;
                result.add(remainder);
            }else {
                result.add(sum);
                carrybit = 0;
            }
        }
        while (!list1.isEmpty()){    //如果第一个数没加完
            int sum = list1.remove(0)  + carrybit;
            if (sum > 9){
                int remainder = sum % 10;  //余数
                carrybit = sum / 10;
                result.add(remainder);
            }else {
                result.add(sum);
                carrybit = 0;
            }
        }
        while (!list2.isEmpty()){   //如果第二个数没加完
            int sum = list2.remove(0)  + carrybit;
            if (sum > 9){
                int remainder = sum % 10;  //余数
                carrybit = sum / 10;
                result.add(remainder);
            }else {
                result.add(sum);
                carrybit = 0;
            }
        }

        if (carrybit != 0){         //如果还有进位
            result.add(carrybit);
        }

        //构建结果链表
        ListNode head = new ListNode(result.get(0));
        ListNode cur = head;
        for (int i = 1; i < result.size(); ++i){
            cur.next = new ListNode(result.get(i));
            cur = cur.next;
        }
        return head;
    }
}
