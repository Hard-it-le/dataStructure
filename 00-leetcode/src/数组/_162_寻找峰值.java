package 数组;

import java.util.Arrays;
import java.util.logging.Level;

/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/19
 */
public class _162_寻找峰值 {

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 2, 1};
        int peakElement = findPeakElement02(array);
        System.out.println(peakElement);

    }

    /**
     * 方法一：二分查找
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1 || nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 前提条件
     *
     *
     * 寻找最大值
     * 由于题目保证了 nums[i] 不等于nums[i+1]
     *  =nums[i+1]，那么数组 nums 中最大值两侧的元素一定严格小于最大值本身。因此，最大值所在的位置就是一个可行的峰值位置。
     *
     * 我们对数组nums 进行一次遍历，找到最大值对应的位置即可
     * @param nums
     * @return
     */
    public static int findPeakElement02(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }

        return index;
    }
}
