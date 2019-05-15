package leetcode;

/**
 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

 示例:
 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 说明:尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */


import java.util.ArrayList;
import java.util.List;

/**
 *思路：本来想用循环穷举所有情况，但是发现循环的个数不固定，因此这种情况得用递归，使用BFS完成
 */
public class Solution {

    private List<String> result = new ArrayList<>();

    String[] dict = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")){
            return result;
        }
        if (digits.length() == 1){
            String temp = dict[Integer.parseInt(digits)];
            for (char ch : temp.toCharArray()){
                result.add(String.valueOf(ch));
            }
            return result;
        }
        letterCombinations(digits.substring(0,digits.length() - 1));
        List<String> tempList = new ArrayList<>();
        for (String s : result){
            String temp2 = dict[Integer.parseInt(String.valueOf(digits.charAt(digits.length() - 1)))];
            for (char ch : temp2.toCharArray()){
                tempList.add(s + ch);
            }
        }
        result = tempList;
        return result;
    }
}