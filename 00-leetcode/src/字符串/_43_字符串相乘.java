package 字符串;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/07
 */
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 示例 1:
//
// 输入: num1 = "2", num2 = "3"
//输出: "6"
//
// 示例 2:
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088"
//
// 说明：
//
//
// num1 和 num2 的长度小于110。
// num1 和 num2 只包含数字 0-9。
// num1 和 num2 均不以零开头，除非是数字 0 本身。
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
//
// Related Topics 数学 字符串 模拟 👍 753 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class _43_字符串相乘 {
    /**
     * 方法一：基于字符串相加的竖式乘法
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply01(String num1, String num2) {
        /**
         * 处理特殊情况，有一个乘数为0，结果就为0
         */
        String zero = "0";
        if (zero.equals(num1) || zero.equals(num2)) {
            return "0";
        }

        // 定义输出结果，直接定义为String，调用字符串相加方法
        String result = "0";

        // 从个位开始遍历num2的每一位，跟num1相乘，并叠加计算结果
        for (int i = num2.length() - 1; i >= 0; i--) {
            // 取出num2的当前数位，作为当前乘法的第二个乘数
            int n2 = num2.charAt(i) - '0';
            // 用一个StringBuffer保存乘积结果
            StringBuffer curResult = new StringBuffer();
            // 定义进位
            int carry = 0;

            // 1. 因为结果是倒序，所以当前n2对应数位要补的0，应该先写入curResult,补n-1-i个0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                curResult.append(zero);
            }

            // 2. 从个位开始遍历num1中的每一位，与n2相乘，并叠加
            for (int j = num1.length() - 1; j >= 0; j--) {
                // 取出num1的当前数位，作为当前乘法的第一个乘数
                int n1 = num1.charAt(j) - '0';
                // 计算当前数位的乘积结果
                int product = n1 * n2 + carry;
                curResult.append(product % 10);
                carry = product / 10;
            }

            // 3. 所有数位乘法计算完毕，如果有进位，需要将进位单独作为一位保存下来
            if (carry != 0) {
                curResult.append(carry);
            }

            // 现在就得到了num1和当前位n2的最终乘积
            // 4. 将当前乘积叠加到result中
            StringBuffer resultAdd = new StringBuffer();
            int m = result.length() - 1;
            int n = curResult.reverse().toString().length() - 1;
            int curryAdd = 0;
            while (m >= 0 || n >= 0 || curryAdd != 0) {
                int m1 = m >= 0 ? result.charAt(m) - '0' : 0;
                int n1 = n >= 0 ? curResult.reverse().toString().charAt(n) - '0' : 0;
                int sum = m1 + n1 + curryAdd;
                resultAdd.append(sum % 10);
                curryAdd = sum / 10;
                m--;
                n--;
            }
            result = resultAdd.reverse().toString();
        }

        return result;
    }

    // 方法二：竖式乘法优化
    public String multiply02(String num1, String num2) {
        // 处理特殊情况，有一个乘数为0，结果就为0
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        // 定义一个数组，保存计算结果的每一位
        int[] resultArray = new int[num1.length() + num2.length()];

        // 遍历num1和num2的每个数位，做乘积，然后找到对应数位，填入结果数组
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                // 计算乘积
                int product = n1 * n2;

                // 保存到结果数组
                int sum = product + resultArray[i + j + 1];
                // 叠加结果的个位保存到i+j+1位置
                resultArray[i + j + 1] = sum % 10;
                resultArray[i + j] += sum / 10;
            }
        }

        // 将结果数组转成String输出
        StringBuffer result = new StringBuffer();
        // 如果最高位为0，从1开始遍历
        int start = resultArray[0] == 0 ? 1 : 0;
        for (int i = start; i < resultArray.length; i++) {
            result.append(resultArray[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "345";
        _43_字符串相乘 v = new _43_字符串相乘();
        String s = v.multiply01(num1, num2);
        System.out.println(s);
    }
}
