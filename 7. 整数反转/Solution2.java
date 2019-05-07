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


/**
 *思路：直接转换成字符串处理     AC
 */
public class Solution2 {
    public int reverse(int x) {      //-2147483648 ~ 2147483647
        if (x > -10 && x < 10) {
            return x;
        }
        boolean isxiaoyu0 = false;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
        String reverse = stringBuilder.reverse().toString();
        if (reverse.charAt(reverse.length() - 1) == '-') {
            isxiaoyu0 = true;
            reverse = reverse.substring(0, reverse.length() - 1);
        }
        int result = 0;
        try {
            result = Integer.parseInt(reverse);   //发生异常说明位数溢出，返回0
        } catch (NumberFormatException e) {
            return 0;
        }
        if (isxiaoyu0) {
            return -result;
        } else {
            return result;
        }
    }
}