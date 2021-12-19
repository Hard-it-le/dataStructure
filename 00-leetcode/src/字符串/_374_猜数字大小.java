package 字符串;

/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/18
 */

//猜数字游戏的规则如下：
//
//
// 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
// 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
//
//
// 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
//
//
// -1：我选出的数字比你猜的数字小 pick < num
// 1：我选出的数字比你猜的数字大 pick > num
// 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
//
//
// 返回我选出的数字。
//
//
//
// 示例 1：
//
//
//输入：n = 10, pick = 6
//输出：6
//
//
// 示例 2：
//
//
//输入：n = 1, pick = 1
//输出：1
//
//
// 示例 3：
//
//
//输入：n = 2, pick = 1
//输出：1
//
//
// 示例 4：
//
//
//输入：n = 2, pick = 2
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= n <= 2³¹ - 1
// 1 <= pick <= n
//
// Related Topics 二分查找 交互 👍 170 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import jdk.nashorn.internal.objects.NativeNumber;

import java.util.Random;

/**
 * Forward declaration of guess API.
 *
 * @param num your guess
 * @return -1 if num is lower than the guess number
 * 1 if num is higher than the guess number
 * otherwise return 0
 * int guess(int num);
 */
public class _374_猜数字大小 {


    static class Test extends GuessGame {

        public int guessNumber(int n) {
            int l = 0;
            int r = n;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if (guess(mid) == 0) {
                    return mid;
                } else if (guess(mid) > 0) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            int n = 19;
            Test test = new Test();
            int i = test.guessNumber(n);
            System.out.println(i);
        }
    }


    static class GuessGame {
        int guess(int num) {
            int min = 1;
            int max = num;
            int i = 0;
            Boolean booleasn = false;

            if (i == 0) {
                i = (int) (Math.random() * (max - min) + min);
                booleasn = true;
            }

            int n=2;
            if (booleasn){
                if (i == num) {
                    return 0;
                } else if (i < num) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return n;

        }
    }


}
