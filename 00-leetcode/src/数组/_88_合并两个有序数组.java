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
     * 时间复杂度为O（log n）
     *
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

    /**
     * 方法二，直接保存
     * 时间复杂度为O（log n）
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge02(int[] nums1, int m, int[] nums2, int n) {
        int n1 = n - 1;
        for (int i = 0; i <= n1; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);

    }

    /**
     * 方法三：双指针法+额外空间
     * 时间复杂度是 O（n）
     * 空间负载度是 O（1)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge03(int[] nums1, int m, int[] nums2, int n) {
        int m1 = 0;
        int n1 = 0;
        int[] sorted = new int[m + n];
        int p;
        while (m1 < m || n1 < n) {
            if (m1 == m) {
                p = nums2[n1];
                n1++;
            } else if (n1 == n) {
                p = nums1[m1];
                m1++;
            } else if (nums1[m1] < nums2[n1]) {
                p = nums1[m1];
                m1++;
            } else {
                p = nums2[n1];
                n1++;
            }
            sorted[m1 + n1 - 1] = p;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }

    }

    /**
     * 方法四。双指针
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge04(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int cur;
        int tail = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

    public static void main(String[] args) {
        _88_合并两个有序数组 v = new _88_合并两个有序数组();
        int[] num1 = {1, 2, 3, 4, 0, 0, 0};
        int n1 = num1.length;
        int[] num2 = {2,5,7};
        int n2 = num2.length;
        int i1 = n1 - n2;
        v.merge04(num1, i1, num2, n2);
        System.out.println(Arrays.toString(num1));
    }
}
