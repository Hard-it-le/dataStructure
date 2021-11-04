package 数组;

import java.util.Arrays;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/03
 */
//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
// 必须 原地 修改，只允许使用额外常数空间。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1]
//输出：[1,2,3]
//
//
// 示例 3：
//
//
//输入：nums = [1,1,5]
//输出：[1,5,1]
//
//
// 示例 4：
//
//
//输入：nums = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100
//
// Related Topics 数组 双指针 👍 1395 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class _31_下一个排列 {

    /**
     * 一次遍历
     * 思路：从后向前找到升序子序列，然后确定调整后子序列的最高位，剩余部分升序排列
     *
     * @param nums
     */
    // 思路：从后向前找到升序子序列，然后确定调整后子序列的最高位，剩余部分升序排列
    public void nextPermutation01(int[] nums) {
        int n = nums.length;
        // 1. 从后向前找到升序子序列，找到第一次下降的数，位置记为k
        int k = n - 2;
        while (k >= 0 && nums[k] >= nums[k + 1]) {
            k--;
        }
        // 找到k，就是需要调整部分的最高位
        // 2. 如果k = -1，说明所有数降序排列，改成升序排列
        if (k == -1) {
            Arrays.sort(nums);
            return;
        }
        // 3. 一般情况，k >= 0
        // 3.1 依次遍历剩余降序排列的部分，找到要替换最高位的那个数
        int i = k + 2;
        while (i < n && nums[i] > nums[k]) {
            i++;
        }
        // 当前的i，就是后面部分第一个比nums[k]小的数，i-1就是要替换的那个数
        // 3.2 交换i-1和k位置上的数
        int temp = nums[k];
        nums[k] = nums[i - 1];
        nums[i - 1] = temp;
        // 3.3 k之后的剩余部分变成升序排列，直接前后调换
        int start = k + 1;
        int end = n - 1;
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    /**
     * 方法改进：将降序数组翻转的操作提取出来
     *
     * @param nums
     */
    public void nextPermutation02(int[] nums) {
        int n = nums.length;
        // 1. 从后向前找到升序子序列，找到第一次下降的数，位置记为k
        int k = n - 2;
        while (k >= 0 && nums[k] >= nums[k + 1]) {
            k--;
        }
        // 找到k，就是需要调整部分的最高位
        // 2. 如果k = -1，说明所有数降序排列，改成升序排列
        if (k == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // 3. 一般情况，k >= 0
        // 3.1 依次遍历剩余降序排列的部分，找到要替换最高位的那个数
        int i = k + 2;
        while (i < n && nums[i] > nums[k]) {
            i++;
        }

        // 当前的i，就是后面部分第一个比nums[k]小的数，i-1就是要替换的那个数
        // 3.2 交换i-1和k位置上的数
        swap(nums, k, i - 1);

        // 3.3 k之后的剩余部分变成升序排列，直接前后调换
        reverse(nums, k + 1, n - 1);
    }

    /**
     * 定义一个方法，交换数组中两个元素
     *
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 定义一个翻转数组的方法
     *
     * @param nums
     * @param start
     * @param end
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 8, 4, 6, 5, 4, 3, 2, 1};
        _31_下一个排列 v = new _31_下一个排列();
        v.nextPermutation02(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }
}
