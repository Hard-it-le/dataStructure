package 字符串;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/07
 */
//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
//
//
//
// 示例 1：
//
//
//输入：num1 = "11", num2 = "123"
//输出："134"
//
//
// 示例 2：
//
//
//输入：num1 = "456", num2 = "77"
//输出："533"
//
//
// 示例 3：
//
//
//输入：num1 = "0", num2 = "0"
//输出："0"
//
//
//
//
//
//
// 提示：
//
//
// 1 <= num1.length, num2.length <= 10⁴
// num1 和num2 都只包含数字 0-9
// num1 和num2 都不包含任何前导零
//
// Related Topics 数学 字符串 模拟 👍 462 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class _415_字符串相加 {

    /**
     * 时间复杂度O（n）
     *空间复杂度O（n）
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        //1、定义StringBuffer，保存最终结果
        StringBuffer result = new StringBuffer();

        //定义遍历两个字符串的初始位置
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        //用一个变量保存当前进位
        int carry = 0;
        //从个位开始依次遍历所有数位，只要还有数没有计算，就计算，其他位数补0
        while (i >= 0 || j >= 0 || carry != 0) {
            //1、取两数当前的对应数,字符要将asci码转换为数字
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            //2、对当前位求和
            int sum = n1 + n2 + carry;

            //3、把sum的个位保存到结果中,十位作为进位保存下来
            result.append(sum % 10);
            carry = sum / 10;
            //4、移动指针，继续遍历下一位
            i--;
            j--;
        }
        return result.reverse().toString();

    }

    public static void main(String[] args) {
        String num1 = "12341";
        String num2 = "342";
        _415_字符串相加 v = new _415_字符串相加();
        String s = v.addStrings(num1, num2);
        System.out.println(s);
    }
}
