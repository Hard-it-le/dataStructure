package 数组;

import java.io.File;

/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2022/01/12
 */
/*

给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。

如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，
使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。

示例 1：

输入：nums = [1,2,3,4,5]
输出：true
解释：任何 i < j < k 的三元组都满足题意
示例 2：

输入：nums = [5,4,3,2,1]
输出：false
解释：不存在满足题意的三元组
示例 3：

输入：nums = [2,1,5,0,4,6]
输出：true
解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6

提示：

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1
 

进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？


 */
public class _334_递增的三元子序列 {

    public static void main(String[] args) {
        int[] ints = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        _334_递增的三元子序列 v = new _334_递增的三元子序列();
        boolean b = v.increasingTriplet02(ints);
        System.out.println(b);
    }

    /**
     * 暴力破解
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet01(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] < nums[j] && nums[j] < nums[k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * 贪心算法
     *
     * 取出数组中第一个数字，然后取出第二个小的数字
     * 依次循环数组
     * 判断当前数与第一位数和第二位数的大小
     * 如果当前数大于第二小的数字，那么返回true
     * 如果当前数大于第一位数，则secondMinNum=num
     * 如果当前数小于第一位数，则表示minNum=num
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet02(int[] nums) {
        int n = nums.length;
        if (n<3){
            return false;
        }
        int minNum = nums[0];
        int secondMinNum =Integer.MAX_VALUE;

        for (int i = 1; i <n ; i++) {

            int num = nums[i];
            if (num >secondMinNum){
                return true;
            }else if (num> minNum){
                secondMinNum=num;
            }else {
                minNum=num;
            }
        }
        return false;
    }
}
