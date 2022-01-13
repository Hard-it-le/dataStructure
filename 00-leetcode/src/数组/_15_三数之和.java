package 数组;

import java.util.*;

/**
 * @program: data-structure
 * @author: yjl
 * @created: 2021/11/03
 */
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -10⁵ <= nums[i] <= 10⁵
//
// Related Topics 数组 双指针 排序 👍 3935 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class _15_三数之和 {

    public static void main(String[] args) {
        int[] nums = {-1, 0,};
        int[] nums1 = {0, 0, 0, 0, 0};
        _15_三数之和 v = new _15_三数之和();
        List<List<Integer>> lists = v.threeSum02(nums);
        System.out.println(lists);
    }


    /**
     * 方法1 暴力破解
     * 缺点：时间复杂度是O（n^3）耗时非常长，效果很不好
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum01(int[] nums) {
        int n = nums.length;
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (n < 3) {
            return result;
        }

        Arrays.sort(nums);
        //三重for循环,枚举所有的三数组合
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        if (!result.contains(tmp)) {
                            result.add(tmp);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 方法二、使用哈希表来保存结果
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum02(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (n < 3) {
            return result;
        }
        // 定义一个hash map
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // 遍历数组，寻找每个数对应的那个数
        for (int i = 0; i < n; i++) {
            int thatNum = 0 - nums[i];
            if (map.containsKey(thatNum)) {
                // 如果已经存在thatNum，就找到了一组解
                ArrayList<Integer> tempList = new ArrayList<>(map.get(thatNum));
                tempList.add(nums[i]);
                result.add(tempList);
                continue;
            }

            // 把当前数对应的两数组合都保存到map里
            for (int j = 0; j < i; j++) {
                // 以两数之和作为key
                int newKey = nums[i] + nums[j];
                // 如果key不存在，就直接添加进去
                if (!map.containsKey(newKey)) {
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    map.put(newKey, tempList);
                }
            }
        }
        return result;

    }


    /**
     * 方法三：双指针
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum03(int[] nums) {
        int n = nums.length;
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (n < 3) {
            return result;
        }

        Arrays.sort(nums);
        //1。遍历每一个元素，作为三个元素中数组中最小的那个（最挨个作为核心）
        for (int i = 0; i < n; i++) {
            //1、如果当前数大于0，这直接跳出循环
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //1.3、常用情况  ，以当前数为最小数，定义左右指针
            int left = i + 1;
            int right = n - 1;
            //只要左右指针不重叠，移动指针
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    //1.3.1、如果等于0，就找到一组解
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    //如果移动之后元素相等，就跳过
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {
                    //1.3.2、小于0，较小的数增大，左指针右移
                    left++;
                } else {
                    //1.3.3、大于0，较大的数减少，右指针左移
                    right--;
                }
            }
        }
        return result;
    }


}
