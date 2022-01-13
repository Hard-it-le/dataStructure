package 数组;

/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2022/01/13
 */
//给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
//
// 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：nums = [3,6,1,0]
//输出：1
//解释：6 是最大的整数，对于数组中的其他整数，6 大于数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3,4]
//输出：-1
//解释：4 没有超过 3 的两倍大，所以返回 -1 。
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：0
//解释：因为不存在其他数字，所以认为现有数字 1 至少是其他数字的两倍。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 50
// 0 <= nums[i] <= 100
// nums 中的最大元素是唯一的
//
// Related Topics 数组 排序 👍 114 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class _747_至少是其他数字两倍的最大数 {

    public static void main(String[] args) {
        _747_至少是其他数字两倍的最大数 v = new _747_至少是其他数字两倍的最大数();
        int[] ints = {1, 2, 3, 4,10};
        int i = v.dominantIndex01(ints);
    }

    /**
     * 暴力循环
     * 遍历数组分别找到数组的最大值m和次最大值n，如果m>n*2,则最大值至少是数组其余数字的两倍，
     * 此时返回最大值的下标，否则返回 -1−1。
     * 为了返回最大值的下标，我们需要在计算最大值的同时记录最大值的下标。
     *
     * 只要最大的值大于第二大的值的两倍，就比其他值都大于两倍
     * @param nums
     * @return
     */
    public int dominantIndex01(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        //定义最大值
        int m = -1;
        //定义第二大的值
        int n = -1;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            //如果index的值大于最大值，则进行替换
            if (nums[i] > m) {
                n = m;
                m = nums[i];
                //记录最大值的索引位置
                index = i;
            } else if (nums[i] > n) {
                //如果当前值小于最大值，但是大于第二大值，则n等于当前索引的值
                n= nums[i];
            }
        }
        return m >= n * 2 ? index : -1;
    }


    /**
     * 模拟法
     * @param nums
     * @return
     */
    public int dominantIndex02(int[] nums) {
        int n = nums.length;
        int a = -1, b = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[b]) {
                a = b;
                b = i;
            } else if (a == -1 || nums[i] > nums[a]) {
                a = i;
            }
        }
        return nums[b] >= nums[a] * 2 ? b : -1;
    }
}
