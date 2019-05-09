package leetcode;

/**
 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

 示例 1:
 输入: 121
 输出: true

 示例 2:
 输入: -121
 输出: false
 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

 示例 3:
 输入: 10
 输出: false
 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */



/**
 *思路:转换成字符串，使用StringBuilder的reverse()翻转字符，比较翻转前后字符是否相等   AC
 */
public class Solution {
    public boolean isPalindrome(int x) {
        String pre = String.valueOf(x);
        StringBuilder sb = new StringBuilder(pre);
        String cur = sb.reverse().toString();
        if (pre.equals(cur)){
            return true;
        }else {
            return false;
        }
    }
}