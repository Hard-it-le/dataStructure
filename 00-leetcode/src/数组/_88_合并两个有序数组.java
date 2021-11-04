package 数组;

import java.util.Arrays;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/04
 */
public class _88_合并两个有序数组 {
    /**
     * 方法一，直接循环排序
     * 时间复杂度为O（n）
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge01(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        _88_合并两个有序数组 v = new _88_合并两个有序数组();
        int[] num1 = {1, 2, 3, 4, 0, 0, 0};
        int n1=num1.length;
        int[] num2 = {9, 1, 6};
        int n2 = num2.length;
        int i1 = n1 - n2;
        v.merge01(num1, i1, num2, n2);
        System.out.println(Arrays.toString(num1));
    }
}
