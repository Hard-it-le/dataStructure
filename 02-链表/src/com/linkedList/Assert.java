package com.linkedList;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/16
 */
public class Assert {
    public static void test(boolean value) {
        try {
            if (!value) {
                throw new Exception("测试未通过");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
