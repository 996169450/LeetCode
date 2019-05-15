package leetcode;

/**
 编写一个函数来查找字符串数组中的最长公共前缀。
 如果不存在公共前缀，返回空字符串 ""。

 示例 1:
 输入: ["flower","flow","flight"]
 输出: "fl"

 示例 2:
 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。

 说明:
 所有输入只包含小写字母 a-z 。
 */



/**
 *思路：分治法
 */
public class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        for (String s : strs){
            if (s.equals("")){
                return "";
            }
        }
        return getCommonPrefix(strs,0,strs.length - 1);
    }

    /**
     * 一分为二
     * @param strs
     * @param left
     * @param right
     * @return
     */
    public String getCommonPrefix(String [] strs, int left, int right){
        if (left == right){
            return strs[left];
        }else {
            int mid = (left + right)/2;
            String leftCommonPrefix = getCommonPrefix(strs,left,mid);
            String rightCommonPrefix = getCommonPrefix(strs,mid+1,right);
            return combin(leftCommonPrefix,rightCommonPrefix);
        }
    }

    /**
     * 取左右两个部分的最长公共序列
     * @param leftString
     * @param rightString
     * @return
     */
    public String combin(String leftString, String rightString){
        int min = Math.min(leftString.length(),rightString.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < min;++i){
            if (leftString.charAt(i) == rightString.charAt(i)){
                sb.append(leftString.charAt(i));
            }else {
                break;
            }
        }
        return sb.toString();
    }

}