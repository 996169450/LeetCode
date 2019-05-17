package leetcode;

/**
 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

 例如，给出 n = 3，生成结果为：
 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *简单思路：列举所有可能得组合（使用递归），再找出合法的组合集              AC
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> all = getAll(2 * n);
        List<String> result = new ArrayList<>();
        for (String s : all){
            if(checkout(s)){
                result.add(s);
            }
        }
        return result;
    }

    private List<String> getAll(int n){
        if (n == 1){
            String[] strs = {"(",")"};
            return Arrays.asList(strs);
        }
        List<String> oldList = getAll(n - 1);
        List<String> newList = new ArrayList<>();
        for (String s : oldList){
            newList.add("(" + s);
            newList.add(")" + s);
        }
        return newList;
    }

    private boolean checkout(String s){
        int count = 0;
        for (char ch : s.toCharArray()){
            if (ch == '('){
                ++count;
            }
            if (ch == ')'){
                --count;
            }
            if (count < 0){        //说明有未配对的) ,例如()))((
                return false;
            }
        }
       return count == 0;
    }
}
