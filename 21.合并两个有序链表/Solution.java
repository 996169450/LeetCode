package leetcode;

/**
 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 示例：
 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 */


/**
 *思路：依次比较合并就可以了，要注意记录头节点               AC
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode guard = new ListNode(0);
        ListNode temp = guard;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            }else {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }
        }
        if (l1 != null){
            temp.next = l1;
        }
        if (l2 != null){
            temp.next = l2;
        }
        return guard.next;
    }
}
