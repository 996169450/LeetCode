package leetcode;

/**
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 有效字符串需满足：
 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 示例 1:
 输入: "()"
 输出: true

 示例 2:
 输入: "()[]{}"
 输出: true

 示例 3:
 输入: "(]"
 输出: false

 示例 4:
 输入: "([)]"
 输出: false

 示例 5:
 输入: "{[]}"
 输出: true
 */


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *简单思路：使用栈来做括号匹配
 */
public class Solution {
    public boolean isValid(String s) {
        if (s == null){
            return false;
        }
        if (s.equals("")){
            return true;
        }
        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for (int i = 0; i < chs.length; ++i){
            if (chs[i] == '(' || chs[i] == '{' || chs[i] == '['){    //遇到左括号就压入栈
                stack.push(chs[i]);
            }else {
                if (stack.isEmpty()){
                    return false;
                }else {
                    char temp = stack.pop();
                    if (chs[i] != map.get(temp)){
                        return false;
                    }
                }
            }
        }
        if (!stack.isEmpty()){
            return false;
        }

        return true;
    }
}
