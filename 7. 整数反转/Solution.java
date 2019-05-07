package leetcode;

/**
 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

 示例 1:
 输入: 123
 输出: 321

 示例 2:
 输入: -123
 输出: -321

 示例 3:
 输入: 120
 输出: 21
 */


import java.util.ArrayList;
import java.util.List;

/**
 *思路：从低位到高位依次加入list，再从list取出数据组合成翻转后的数，溢出就返回0。如果是负数，先记录再把负数变正数然后处理     AC
 */
public class Solution {
    public int reverse(int x) {      //-2147483648 ~ 2147483647
        if (x > -10 && x < 10){
            return x;
        }
        boolean isxiaoyu0 = false;
        if (x < 0){
            isxiaoyu0 = true;
            x = -x;
            if (x == -x){          //-2147483648去正数的时候超出了int能标识的范围
                return 0;
            }
        }
        List<Integer> list = new ArrayList<>();
        while (x > 0){
            list.add(x % 10);
            x /= 10;
        }
        long sum = list.get(0);
        for (int i = 1; i < list.size(); ++i){
            sum = sum * 10 + list.get(i);   //这里如果sum用int型，会有溢出的问题
            if (sum > Math.pow(2,31) - 1){
                return 0;
            }
        }
        if (isxiaoyu0){
            return (int)-sum;
        }else {
            return (int)sum;
        }
    }
}
