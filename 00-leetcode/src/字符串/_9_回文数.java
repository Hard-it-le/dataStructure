package 字符串;

/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2022/01/26
 */
//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
//
//
//
// 示例 1：
//
//
//输入：x = 121
//输出：true
//
//
// 示例 2：
//
//
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
//
// 示例 3：
//
//
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
//
//
// 示例 4：
//
//
//输入：x = -101
//输出：false
//
//
//
//
// 提示：
//
//
// -2³¹ <= x <= 2³¹ - 1
//
//
//
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？
// Related Topics 数学 👍 1780 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class _9_回文数 {

    public static void main(String[] args) {
        _9_回文数 v = new _9_回文数();
        boolean palindrome01 = v.isPalindrome01(123);
        System.out.println(palindrome01);
    }

    /**
     * 方法一
     * 整数转为字符串
     * 然后将字符串分割为数组
     * 只需要循环数组的一半长度进行判断对应元素是否相等
     *
     * @param x
     * @return
     */
    public boolean isPalindrome01(int x) {
        StringBuilder stringBuilder = new StringBuilder(x + "");
        //数组反转123->321
        String reversedStr = (stringBuilder).reverse().toString();
        System.out.println(reversedStr);
        return (x + "").equals(reversedStr);
    }

    /**
     *
     * 反转一半数字
     * @param x
     * @return
     */
    public boolean isPalindrome02(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;

        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x * 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
