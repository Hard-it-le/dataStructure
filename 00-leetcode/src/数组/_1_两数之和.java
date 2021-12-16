package 数组;
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：nums = [3,3], target = 6
//输出：[0,1]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 103
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// 只会存在一个有效答案
//
// Related Topics 数组 哈希表
// 👍 10797 👎 0

import java.util.HashMap;
import java.util.Map;

public class _1_两数之和 {

    /**
     * 方法1  暴力破解（双重遍历）
     * 时间复杂度 O（n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum01(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 方法二
     * * 通过hashmap来解决两数之和
     * *首先定义一个map，然后通过target减去nums[i]得到的值value，
     * * 在判断map中是否含有value，如果有，在返回map得到值的小标和i；
     * 时间复杂度  O（n）
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum02(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < len; i++) {
            int value = target - nums[i];
            if (map.containsKey(value) && map.get(value) != i) {
                return new int[]{i, map.get(value)};
            }
        }
        return new int[0];
    }


    /**
     * 方法三
     * 通过hashmap来解决两数之和
     * 遍历数组，寻找每个数对应的那个数上否存在（往前走）,如果没有则添加
     * 时间复杂度  O（n）
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum03(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int value = target - nums[i];
            if (map.containsKey(value)) {
                return new int[]{map.get(value), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] arr = {3, 2, 4};
        int target = 6;
        _1_两数之和 v = new _1_两数之和();
        int[] ints = v.twoSum03(arr, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
