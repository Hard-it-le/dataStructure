/**
 * @author yujiale
 * @Classname Main
 * @Description TOO
 * @Date 2021/9/16 下午8:17
 * @Created by yujiale
 * <p>
 * 一般从一下纬度来评估算法的优劣
 * **正确性、可读性、健壮性
 * ** 时间复杂度：估算程序指令的执行次数（执行时间）
 * ** 空间复杂度：估算所需占用的存储空间
 */
public class Main {
    public static void main(String[] args) {
        compare();
    }

    /**
     * 比较斐波拉契数中递归算法和优化算法的时间
     */
    public static void compare() {
        Times.test("fib1", new Times.Task() {
            @Override
            public void execute() {
                System.out.println("优化算法");
                System.out.println(fib1(46));
            }
        });
        Times.test("fib", new Times.Task() {
            @Override
            public void execute() {
                System.out.println("递归算法");
                System.out.println(fib(46));
            }
        });

    }

    /**
     * 求第n个斐波拉契数
     * 0 1 1 2 3 5 8 13
     * 递归
     * log2(n)
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 求第n个斐波拉契数解法二
     * O(n)
     *
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    /**
     * 大O表示法
     *
     * 9 >> O(1)
     * 2n+3 >> O(n)
     * n^2 +2n  >> O(n^2)
     * n^3 + n^2 + n >> O(n^3)
     * O(log(n))
     * O(nlog(n))
     * O(e^n) (指数函数）
     * 注意：大O表示法仅仅是一种粗略的分析模型，是一种估算，能帮助我们短时间内了解一个算法的执行效率
     */

    /**
     * 估算时间复杂度
     */
    public static void test01(int n) {
        if (n > 10) {
            System.out.println("n > 10");
        } else if (n > 5) {
            System.out.println("n > 5");
        } else {
            System.out.println("n <= 5");
        }
        // 1 + 4 + 4 + 4
        for (int i = 0; i < 4; i++) {
            System.out.println("test");
        }
    }

    public static void test02(int n) {
        // O(n)
        // 1 + 3n
        for (int i = 0; i < n; i++) {
            System.out.println("test");
        }
    }

    public static void test03(int n) {
        // 1 + 2n + n * (1 + 3n)
        // 1 + 2n + n + 3n^2
        // 3n^2 + 3n + 1
        // O(n^2)
        // O(n)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("test");
            }
        }
    }

    public static void test04(int n) {
        // 1 + 2n + n * (1 + 45)
        // 1 + 2n + 46n
        // 48n + 1
        // O(n)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.println("test");
            }
        }
    }

    public static void test05(int n) {
        // 8 = 2^3
        // 16 = 2^4
        // 3 = log2(8)
        // 4 = log2(16)

        // 执行次数 = log2(n)
        // O(logn)
        while ((n = n / 2) > 0) {
            System.out.println("test");
        }
    }

    public static void test06(int n) {
        // log5(n)
        // O(logn)
        while ((n = n / 5) > 0) {
            System.out.println("test");
        }
    }

    public static void test07(int n) {
        // 1 + 2*log2(n) + log2(n) * (1 + 3n)
        // 1 + 3*log2(n) + 2 * nlog2(n)
        // O(nlogn)
        for (int i = 1; i < n; i = i * 2) {
            // 1 + 3n
            for (int j = 0; j < n; j++) {
                System.out.println("test");
            }
        }
    }

    public static void test08(int n) {
        int a = 10;
        int b = 20;
        int c = a + b;
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + c);
        }
    }
}
