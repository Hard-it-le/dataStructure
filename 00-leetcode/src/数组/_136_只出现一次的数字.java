package 数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2022/01/14
 */
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,1]
//输出: 1
//
//
// 示例 2:
//
// 输入: [4,1,2,1,2]
//输出: 4
// Related Topics 位运算 数组 👍 2187 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class _136_只出现一次的数字 {

    public static void main(String[] args) {

    }

    /**
     * 暴力循环
     * <p>
     * 时间复杂度 O（n^2）
     * 空间复杂度 O（1）
     *
     * @param nums
     * @return
     */
    public int singleNumber01(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    cnt++;
                }
            }
            if (cnt == 1) {
                return nums[i];
            }
        }

        return -1;
    }


    /**
     * 快速排序
     * <p>
     * 时间复杂度 O(n logn)
     * 空间复杂度  O(1)
     *
     * @param nums
     * @return
     */
    public int singleNumber02(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /**
     * hashMap
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public int singleNumber03(int[] nums) {
        //记录数字的出现次数，键为数字，值为出现次数
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }


    /**
     * 位运算异或
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int singleNumber04(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            //将所有数字进行异或
            ans = ans ^ nums[i];
        }
        return ans;
    }

}
