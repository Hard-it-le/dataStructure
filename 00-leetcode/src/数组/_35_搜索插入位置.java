package 数组;

import java.util.Arrays;

/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/13
 */

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 请必须使用时间复杂度为 O(log n) 的算法。
//
//
//
// 示例 1:
//
//
//输入: nums = [1,3,5,6], target = 5
//输出: 2
//
//
// 示例 2:
//
//
//输入: nums = [1,3,5,6], target = 2
//输出: 1
//
//
// 示例 3:
//
//
//输入: nums = [1,3,5,6], target = 7
//输出: 4
//
//
// 示例 4:
//
//
//输入: nums = [1,3,5,6], target = 0
//输出: 0
//
//
// 示例 5:
//
//
//输入: nums = [1], target = 0
//输出: 0
//
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums 为无重复元素的升序排列数组
// -10⁴ <= target <= 10⁴
//
// Related Topics 数组 二分查找 👍 1217 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class _35_搜索插入位置 {


    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6};
        int target = 5;
        int i = searchInsert02(arr, target);
        System.out.println(i);
    }

    /**
     * 方法一：二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid =  l+ ((r-l)>>1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 方法二：暴力破解
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert02(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        for (int i = 0; i < n ; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return n;
    }
}
