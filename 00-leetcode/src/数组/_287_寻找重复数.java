package 数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/04
 */
//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
//
// 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
//
// 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,3,4,2,2]
//输出：2
//
//
// 示例 2：
//
//
//输入：nums = [3,1,3,4,2]
//输出：3
//
//
// 示例 3：
//
//
//输入：nums = [1,1]
//输出：1
//
//
// 示例 4：
//
//
//输入：nums = [1,1,2]
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁵
// nums.length == n + 1
// 1 <= nums[i] <= n
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
//
//
//
//
// 进阶：
//
//
// 如何证明 nums 中至少存在一个重复的数字?
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
//
// Related Topics 位运算 数组 双指针 二分查找 👍 1451 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class _287_寻找重复数 {
    /**
     * 方法1：使用hashmap保存每个数
     * 时间复杂度O(n）
     * 空间复杂度 O(n)
     * 不符合进阶要求
     *
     * @param nums
     * @return
     */
    public int findDuplicate01(int[] nums) {
        int n = nums.length;
        if (n == 2) {
            return nums[0];
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (Integer num : nums) {
            //判断当前num是否在key中存在
            if (countMap.containsKey(num)) {
                return num;
            }
            countMap.put(num, 1);
        }
        return -1;
    }

    /**
     * 方法二、使用hashset保存数据，判断是否出现过
     * *  时间复杂度O(n）
     * *  空间复杂度 O(n)
     * 不符合进阶要求
     *
     * @param nums
     * @return
     */
    public int findDuplicate02(int[] nums) {
        int n = nums.length;
        if (n == 2) {
            return nums[0];
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                return num;
            }
            hashSet.add(num);
        }
        return -1;
    }

    /**
     * 方法三：先排序，相邻元素的相同元素
     * 时间复杂度 O(log n)
     * 空间复杂度 O(1)
     * 同时不符合进阶要求，改变了nums数组
     *
     * @param nums
     * @return
     */
    public int findDuplicate03(int[] nums) {
        int n = nums.length;
        if (n == 2) {
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 方法四、二分查找，查找1~N的自然数序列，寻找target
     * <p>
     * 时间复杂度 O(nlog n))
     * 空间复杂度 O（1）
     *
     * @param nums
     * @return
     */
    public int findDuplicate04(int[] nums) {
        int n = nums.length;
        if (n == 2) {
            return nums[0];
        }
        // 定义左右指针
        int left = 1;
        int right = nums.length - 1;
        while (left <= right) {
            // 计算中间值
            int mid = (left + right) / 2;
            // 对当前的mid计算count值
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            // 判断count和mid本身的大小关系
            if (count <= mid) {
                // count小于等于mid自身，说明mid比target小，左指针右移
                left = mid + 1;
            } else {
                right = mid;
            }
            // 左右指针重合时，找到target
            if (left == right) {
                return left;
            }
        }
        return -1;
    }

    /**
     * 方法五、快慢指针
     *
     * @param nums
     * @return
     */
    public int findDuplicate05(int[] nums) {
        int n = nums.length;
        if (n == 2) {
            return nums[0];
        }
        // 定义快慢指针
        int fast = 0, slow = 0;
        // 1. 寻找环内的相遇点
        do {
            // 快指针一次走两步，慢指针一次走一步
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        // 循环结束，slow和fast相等，都是相遇点
        // 2. 寻找环的入口点
        // 另外定义两个指针，固定间距
        int before = 0, after = slow;
        while (before != after) {
            before = nums[before];
            after = nums[after];
        }

        // 循环结束，相遇点就是环的入口点，也就是重复元素
        return before;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 4};
        _287_寻找重复数 v = new _287_寻找重复数();
        int duplicate01 = v.findDuplicate04(arr);
        System.out.println(duplicate01);
    }
}
