import java.math.BigDecimal;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * x^n = x^{n/2} \times x^{n/2} = (x^2)^{n/2}x
 * n
 * =x
 * n/2
 * ×x
 * n/2
 * =(x
 * 2
 * )
 * n/2
 * ，令 n/2n/2 为整数，则需要分为奇偶两种情况（设向下取整除法符号为 "////" ）：
 * <p>
 * 当 nn 为偶数： x^n = (x^2)^{n//2}x
 * n
 * =(x
 * 2
 * )
 * n//2
 * ；
 * 当 nn 为奇数： x^n = x(x^2)^{n//2}x
 * n
 * =x(x
 * 2
 * )
 * n//2
 * ，即会多出一项 xx
 * <p>
 * 作者：jyd
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution16 {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1/x;
        double half = myPow(x, n / 2);
        return half * half * myPow(x, n % 2);   // 即为 x^(n/2) * x^(n/2) * x(n%2) = x^n
    }

    public static void main(String[] args) {
        System.out.println(new Solution16().myPow(2.1, 3));
    }
}

