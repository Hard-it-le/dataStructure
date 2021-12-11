package com;

/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/10
 * <p>
 * 位运算 第一课
 */
public class BitOperation {
    public static void main(String[] args) {
        //bitOperationTest();
        print(-2);
    }


    public static void print(Integer num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    /**
     * 位运算测试
     */
    public static void bitOperationTest() {
        int a = 1231111;
        int b = 192939;
        print(a);
        print(b);
        System.out.println("============");
        //或运算（两个数其中一个为1都可以是1）
        print(a | b);
        System.out.println("============");
        //与运算（两个都为1才能为1，否则都是0）
        print(a & b);
        System.out.println("============");
        //异或运算（两个相同为0，不同为1）
        print(a ^ b);
    }

    /**
     * 原码：
     * 0 表示正数
     * 1 表示负数   （负数的原码：除去符号位其他的位取反后+1）
     * 1： 0000 0001
     * -1：1000 0001
     * -2：1000 0010
     * 反码：
     * 正数的反码与原码一致
     * 负数的反码是符号位不变，其他位置取反
     * 1： 0000 0001
     * -1：1111 1110
     * -2：1111 1101
     * 补码
     * 正数的补码与原码一致
     * 负数的补码是在反码的基础上+1
     * 1： 0000 0001
     * -1：1111 1111
     * -2：1111 1110
     * <p>
     * <p>
     * 计算机底层的加减乘除位运算都是一套逻辑，提高运行效率
     */
    public static void test01() {
        System.out.println("Integer最小值：" + Integer.MIN_VALUE);
        System.out.println("Integer最大值：" + Integer.MAX_VALUE);
    }
}
