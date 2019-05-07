package leetcode;

/**
 给定一个字符串，请你找出其中不含有重复字符的 最长子串的长度。

 示例 1:
 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

 示例 2:
 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

 示例 3:
 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

/**
 *简单思路：从第一个字符开始往后查找，遇到不包含的字符，子串长度加1，包含则停止查找。再从第二个字符开始查找..直到最后一个字符，取最长无重复子串
 * 时间复杂度：O(n^2)    AC
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder(s);
        int maxLength = 0;
        while (sb.length() > 0){
            int length = getCurrentMaxLength(sb.toString());
            if (length > maxLength){
                maxLength = length;
            }
            sb.deleteCharAt(0);
        }

        return maxLength;
    }

    private int getCurrentMaxLength(String s){
        if (s == null){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        int maxLength = 0;
        for (int i = 0; i < s.length(); ++i){
            if (sb.toString().contains(String.valueOf(s.charAt(i)))){
                maxLength = sb.length();
                return maxLength;
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.length();
    }
}
