/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"及"-1E-16"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 * <p>
 * 注意：本题与主站 65 题相同：https://leetcode-cn.com/problems/valid-number/
 * <p>
 * 解法
 * 遍历字符串：
 * <p>
 * 出现 +/- 时，位置必须是在第 0 位，或者 e/E 的后面一位
 * 出现 . 时，在此之前不能出现 . 或者 e/E
 * 出现 e/E 时，前面不能出现 e/E，并且必须出现过数字
 */
class Solution20 {
    public boolean isNumber(String s) {
        boolean dotFlag = false;
        boolean eFlag = false;
        boolean numFlag = false;
        for (int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i);
            if (schar == '+' || schar == '-') {
                if (i != 0 && (s.charAt(i - 1) != 'e' || s.charAt(i - 1) != 'E'))
                    return false;
            } else if (schar == '.') {
                if (i == 0) {
                    dotFlag = true;
                    continue;
                }
                if (dotFlag || (s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E'))
                    return false;
                dotFlag = true;
            } else if (schar == 'e' || schar == 'E') {
                if (eFlag || numFlag == false)
                    return false;
            } else {
                numFlag = true;
            }
        }
        return numFlag;
    }
}

