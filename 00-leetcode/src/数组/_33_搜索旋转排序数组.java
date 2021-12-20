package 数组;

/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/20
 */
//整数数组 nums 按升序排列，数组中的值 互不相同 。
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
//
//
// 示例 2：
//
//
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1
//
// 示例 3：
//
//
//输入：nums = [1], target = 0
//输出：-1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5000
// -10^4 <= nums[i] <= 10^4
// nums 中的每个值都 独一无二
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转
// -10^4 <= target <= 10^4
//
//
//
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
// Related Topics 数组 二分查找 👍 1725 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class _33_搜索旋转排序数组 {

    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 6, 7, 1, 2, 3};
        int target = 8;
        _33_搜索旋转排序数组 v = new _33_搜索旋转排序数组();
        int search = v.search(array, target);
        System.out.println(search);
    }


    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            //如果刚好mid位置的元素等于target，则直接返回mid
            if (nums[mid] == target) {
                return mid;
            }
            //如果mid位置的元素大于等于第一个0位置的元素，则表示l到mid位置是有序数组
            if (nums[mid] >= nums[l]) {
                //如果num[mid] 大于target，并且target >=num[l],则r=mid-1；
                if (nums[l] <= target && nums[mid] > target) {
                    r = mid - 1;
                } else {
                    //否则l=mid+1；
                    l = mid + 1;
                }
            } else {
                //否则mid位置到r是有序数组
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * 方法二：循环遍历
     * @param nums
     * @param target
     * @return
     */
    public int search01(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
